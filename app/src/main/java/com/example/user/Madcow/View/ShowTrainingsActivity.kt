package com.example.user.Madcow.View

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.Madcow.Adapters.TrainingsAdapter

import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.ExercisesViewModel
import com.example.user.Madcow.ViewModel.TrainingsViewModel

import javax.inject.Inject

import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ShowTrainingsActivity : AppCompatActivity() {

    @Inject lateinit var trainingsViewModel : TrainingsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private  var trainingList: MutableList<Training> = mutableListOf()
    private lateinit var compositeDisposable : CompositeDisposable


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_list)

        val firstTrainingOfWeek = intent.getStringExtra("weekOfCycle").toInt()
        compositeDisposable = CompositeDisposable()


        viewManager = LinearLayoutManager(this)
        viewAdapter = TrainingsAdapter(trainingList){ training : Training -> showTraining(training)}

        recyclerView = findViewById<RecyclerView>(R.id.training_recycler_view).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }


        compositeDisposable.add(
                trainingsViewModel.getTrainigsForWeek(firstTrainingOfWeek)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    trainingList.add(it)
                    viewAdapter.notifyDataSetChanged()}
                .subscribe())

    }



    private fun showTraining(training : Training) {
        val intent = Intent(this@ShowTrainingsActivity, ShowExercisesActivity::class.java);
        intent.putExtra("trainingId", training.id.toString())
        startActivity(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}

