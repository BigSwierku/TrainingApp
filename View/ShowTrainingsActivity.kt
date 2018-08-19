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
import io.reactivex.schedulers.Schedulers

class ShowTrainingsActivity : AppCompatActivity() {

    @Inject lateinit var trainingsViewModel : TrainingsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var trainingList: MutableList<Training>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_list)

        val firstTrainingOfWeek = intent.getStringExtra("trainingId").toInt()
            trainingsViewModel.getTrainigsForWeek(firstTrainingOfWeek).subscribeOn(Schedulers.io()).doOnNext {
            trainingList.add(it)
            viewAdapter.notifyDataSetChanged() }.observeOn(AndroidSchedulers.mainThread())

                viewManager = LinearLayoutManager(this)
        viewAdapter = TrainingsAdapter(trainingList){ training : Training -> showTraining(training)}

        recyclerView = findViewById<RecyclerView>(R.id.training_recycler_view).apply {

            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }

    private fun showTraining(training : Training) {
        val intent = Intent(this@ShowTrainingsActivity, ShowExercisesActivity::class.java);
        intent.putExtra("trainingId", training.id)
        startActivity(intent)

    }
}

