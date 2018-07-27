package com.example.user.Madcow.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.Adapters.WeeksAdapter

import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.PlanViewModel
import javax.inject.Inject
import dagger.android.AndroidInjection


//Activity showing plan
class ShowWeeksActivity : AppCompatActivity() {

    @Inject lateinit var planViewModel : PlanViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var weeksList: MutableList<Training>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week_list)


       planViewModel.getPlanHarmonogram().doOnNext {
           weeksList.add(it)
           viewAdapter.notifyDataSetChanged() }


        viewManager = LinearLayoutManager(this)
        viewAdapter = WeeksAdapter(weeksList) { training : Training -> showWeek(training)}

        recyclerView = findViewById<RecyclerView>(R.id.week_recycler_view).apply {

            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }
    private fun showWeek(training : Training) {
        val intent = Intent(this@ShowWeeksActivity, ShowTrainingsActivity::class.java);
        intent.putExtra("trainingId", training.id)
        startActivity(intent)

    }
}
