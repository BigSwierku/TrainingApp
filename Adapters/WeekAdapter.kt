package com.example.user.Madcow.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R
import com.example.user.Madcow.getMainExcersizeForTrainig
import kotlinx.android.synthetic.main.trainig_item.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by User on 2018-06-30.
 */
class WeekAdapter(val items: List<Training>) : RecyclerView.Adapter<WeekAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.trainig_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.weekDay.text = SimpleDateFormat("EEEE", Locale.ENGLISH).format(items[position].date.time)
        holder.mainExcercise.text = items[position].getMainExcersizeForTrainig()
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weekDay = view.week_day
        val mainExcercise = view.main_excercise

    }
}
