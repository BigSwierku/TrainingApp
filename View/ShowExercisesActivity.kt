package com.example.user.Madcow.View

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.Madcow.Adapters.ExercisesAdapter
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.ExercisesViewModel
import com.example.user.Madcow.ViewModel.SeriesViewModel
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ShowExercisesActivity: AppCompatActivity(){

    @Inject
    lateinit var exerciseViewModel : ExercisesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private  var seriesList: MutableList<Series> = mutableListOf()
    private lateinit var compositeDisposable : CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.excersize_list)

        val choosenTraining = intent.getStringExtra("trainingId").toInt()
        compositeDisposable = CompositeDisposable()



        viewManager = LinearLayoutManager(this)
        viewAdapter = ExercisesAdapter(seriesList){series:Series -> showExercise((series))}

        recyclerView = findViewById<RecyclerView>(R.id.exercise_recycler_view).apply {

            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        compositeDisposable.add(exerciseViewModel.getExcersisesForTrainig(choosenTraining)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    seriesList.add(it)
                    viewAdapter.notifyDataSetChanged()}
                .subscribe())
    }

    private fun showExercise(series : Series) {
        val intent = Intent(this@ShowExercisesActivity, ShowSeriesActivity::class.java)
        intent.putExtra("exerciseName", series.excersise)
        intent.putExtra("trainigId",series.trainingId )
        startActivity(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}