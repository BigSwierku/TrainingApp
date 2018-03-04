package com.example.user.Madcow

import java.util.*

/**
 * Created by User on 2018-02-15.
 */
class PlanCreator() {


    fun createTrainingsForPlan(today: Date): List<Training> {
        val trainingList: MutableList<Training>
        for (i in 1..10)
    //        trainingList.add(Training(i, type, date, week))
   //     return trainingList
    }

    fun createSeriesForTrainig(workWeight: Map<Int, Double>, training: Training): List<Series>{
        when(training.type)  {
            1 ->return createMondaySeries(training.id,workWeight)
            2 ->return createWednsdaySeries(training.id,workWeight)
            3 ->return createFridaySeries(training.id,workWeight)

        }
    }
    fun createMondaySeries(id:Int, wokrWeight:Map<Int, Double>):Map<String,List<Series>>{
        val listOfSeries : MutableList<Series>
        listOfSeries= listOf()
        for(i in 1..5) listOfSeries.add(i,Series(id=i,excersise= "Squats",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))

    }
    fun createWednsdaySeries(id:Int, wokrWeight:Map<Int, Double>):List<Series>{

    }
    fun createFridaySeries(id:Int, wokrWeight:Map<Int, Double>):List<Series>{

    }



}