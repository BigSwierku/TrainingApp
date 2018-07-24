package com.example.user.Madcow.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.Madcow.Adapters.PlanAdapter
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.PlanViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ShowExercisesActivity: AppCompatActivity(){

    @Inject
    lateinit var exerciseViewModel : ExerciseViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var seriesList: MutableList<Training>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.excersize_list)


        exerciseViewModel..doOnNext {
            seriesList.add(it)
            viewAdapter.notifyDataSetChanged() }


        viewManager = LinearLayoutManager(this)
        viewAdapter = PlanAdapter(seriesList)

        recyclerView = findViewById<RecyclerView>(R.id.exercise_recycler_view).apply {

            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }
}