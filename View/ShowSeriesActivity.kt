package com.example.user.Madcow.View

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.Madcow.Adapters.SeriesAdapter
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.SeriesViewModel
import com.example.user.Madcow.ViewModel.TimerViewModel
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ShowSeriesActivity : AppCompatActivity(){

    @Inject
    lateinit var seriesViewmodel : SeriesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private  var seriesList: MutableList<Series> = mutableListOf()
    private lateinit var compositeDisposable : CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.series_list)

        val exerciseName = intent.getStringExtra("exerciseName")
        val trainingId = intent.getIntExtra("trainingId",0)

        compositeDisposable = CompositeDisposable()
        viewManager = LinearLayoutManager(this)
        viewAdapter = SeriesAdapter(seriesList){series:Series -> startSeries(series)}
        recyclerView = findViewById<RecyclerView>(R.id.series_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        compositeDisposable.add(seriesViewmodel.getSeriesForExercise(trainingId,exerciseName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    seriesList.add(it)
                    viewAdapter.notifyDataSetChanged() }
                .subscribe())
    }

    private fun startSeries(series : Series) {
        val intent = Intent(this@ShowSeriesActivity, TimerActivity::class.java)
        intent.putExtra("pauseTime", series.pause)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}