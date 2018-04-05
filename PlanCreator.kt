package com.example.user.Madcow

import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training

/**
 * Created by User on 2018-02-15.
 */
class PlanCreator() {


//    fun createTrainingsForPlan(today: Date): List<Training> {
//        val trainingList: MutableList<Training>
//        for (i in 1..10)
//    //        trainingList.add(Training(i, type, date, week))
//   //     return trainingList
//    }

    fun createSeriesForTrainig(workWeight: Map<Int, Double>, training: Training): List<Series>{
        when(training.type) {
            1 -> return createMondaySeries(training.id, workWeight)
            2 -> return createWednsdaySeries(training.id, workWeight)
            3 -> return createFridaySeries(training.id, workWeight)
            else -> throw IllegalArgumentException(" Wrong day of week for trainig!, please set monday, wednsday or friday")
        }

    }




}