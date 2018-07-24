package com.example.user.Madcow.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.R
import com.example.user.Madcow.getMainExcersizeForTrainig
import kotlinx.android.synthetic.main.excersize_item.view.*
import kotlinx.android.synthetic.main.trainig_item.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by User on 2018-06-30.
 */

class TrainingAdapter(val items: List<Series>) : RecyclerView.Adapter<TrainingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.excersize_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.exercise.text = items[position].excersise
        holder.reps.text = items[position].reps.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val exercise = view.excersice_name
        val reps = view.series_amount

    }
}