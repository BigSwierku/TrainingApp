package com.example.user.Madcow.View

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.Madcow.Adapters.SeriesAdapter
import com.example.user.Madcow.Adapters.WeeksAdapter
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.SeriesViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ShowSeriesActivity : AppCompatActivity(){

    @Inject
    lateinit var seriesViewmodel : SeriesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var seriesList: MutableList<Training>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.series_list)


        seriesViewmodel..doOnNext {
            seriesList.add(it)
            viewAdapter.notifyDataSetChanged() }


        viewManager = LinearLayoutManager(this)
        viewAdapter = SeriesAdapter(seriesList,)

        recyclerView = findViewById<RecyclerView>(R.id.series_recycler_view).apply {

            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }
    private fun startSeries(series : Series) {
        val intent = Intent(this@ShowSeriesActivity, TimerActivity::class.java)
        intent.putExtra("pauseTime", series.pause)
        startActivity(intent)

    }
}