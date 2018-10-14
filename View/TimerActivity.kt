package com.example.user.Madcow.View

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.PlanViewModel
import com.example.user.Madcow.ViewModel.TimerViewModel
import dagger.android.AndroidInjection
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.timer_view.*
import rx.Single
import javax.inject.Inject

class TimerActivity : AppCompatActivity() {


    @Inject
    lateinit var timerViewModel : TimerViewModel

    private lateinit var compositeDisposable : CompositeDisposable
    private lateinit var timer : CountDownTimer
    private var timeLeft : Int =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.timer_view)
        compositeDisposable = CompositeDisposable()

        val seriesId = intent.getStringExtra("seriesId").toInt()
        lateinit var  workedSeries  : Series

        compositeDisposable.add(
                timerViewModel.getSeriesById(seriesId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSuccess {
                            workedSeries=it
                            timeLeft = it.pause
                            initTimer(workedSeries.pause)
                            }
                        .subscribe())

        start_button.setOnCheckedChangeListener { _,isChecked ->
            if(isChecked) {
                timer.cancel()
                initTimer(timeLeft)
                timer.start()
                }
            else {
                timeLeft = timer_text.text.toString().toInt()
                timer.cancel()}
        }

        end_button.setOnClickListener {
            start_button.isChecked = false
            timer.cancel()
            timeLeft=workedSeries.pause
            timer_text.setText(timeLeft.toString())
        }

        finished_button.setOnClickListener{
            workedSeries.doneFlag=true
            compositeDisposable.add(
                    Flowable.fromCallable {
                    timerViewModel.markSeriesAsDone(workedSeries)}
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnNext {
                                finish()
                            }
                            .subscribe())
            //todo going back in view
        }

        }

     fun initTimer(countDownTime : Int){
         timer = object :CountDownTimer(countDownTime.toLong()*1000, 1000){

             override fun onTick(msuntilFinished: Long) {
                 timer_text.setText((msuntilFinished/1000).toString())
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