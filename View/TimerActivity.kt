package com.example.user.Madcow.View

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.PlanViewModel
import com.example.user.Madcow.ViewModel.TimerViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.timer_view.*
import javax.inject.Inject

class TimerActivity : AppCompatActivity() {




    @Inject
    lateinit var timerViewModel : TimerViewModel

    private lateinit var compositeDisposable : CompositeDisposable
    private lateinit var  workedSeries  : Series
    private lateinit var timer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_view)

        val seriesId = intent.getStringExtra("seriesId").toInt()

        compositeDisposable.add(
                timerViewModel.getSeriesById(seriesId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSuccess {workedSeries=it
                            }
                        .subscribe())

        start_button.setOnCheckedChangeListener { _,isChecked ->
            if(isChecked) {
                timer = getTimer(workedSeries.pause.toLong())
                timer.start() }
            else {
                workedSeries.pause = timer_text.text.toString().toInt()
                timer.cancel()}
        }

        end_button.setOnClickListener {
            timer = getTimer(workedSeries.pause.toLong())
            timer.start()
        }

        finished_button.setOnClickListener{
            compositeDisposable.add(
                    timerViewModel.markSeriesAsDone(workedSeries)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess {//
                            }
                            .subscribe())
            compositeDisposable.clear()
            //todo going back in view
        }

        }







    private fun getTimer(pauseTime: Long) : CountDownTimer {
        return object : CountDownTimer(pauseTime, 1000){

            override fun onTick(msuntilFinished: Long) {
                timer_text.setText(msuntilFinished.toInt())
            }

            override fun onFinish() {
                timer_text.setText("Pause finished. It's time to get dirty!")
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}