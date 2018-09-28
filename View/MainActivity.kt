package com.example.user.Madcow.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.MainViewModel
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private lateinit var compositeDisposable : CompositeDisposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        compositeDisposable = CompositeDisposable()


        add_new_plan.setOnClickListener { startActivity(Intent(this, AddPlanActivity::class.java)) }
        check_existing_plan.setOnClickListener { startActivity(Intent(this, ShowWeeksActivity::class.java)) }


        show_today_training.setOnClickListener { compositeDisposable.add(
                mainViewModel.getTrainingForToday()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .switchIfEmpty { showRestDayAlert() }
                        .doOnSuccess {showTraining(it)}
                        //.doOnError { showRestDayAlert() }
                        .subscribe())
        }


    }

    private fun showTraining(training : Training) {
        val intent = Intent(this@MainActivity, ShowExercisesActivity::class.java);
        intent.putExtra("trainingId", training.id.toString())
        startActivity(intent)

    }
    private  fun showRestDayAlert(){
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("It's a rest day")
        builder.setMessage("You don't have any training today. It seems that today is a rest Day ")
        builder.setNeutralButton("Rest"){_,_ ->
            Toast.makeText(applicationContext,"Enjoy your free time", Toast.LENGTH_SHORT).show()
            compositeDisposable.clear()
        }
        builder.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
