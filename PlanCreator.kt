package com.example.user.Madcow

import java.util.*

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
     fun  createMondaySeries(id:Int, wokrWeight:Map<Int, Double>):List<Series>{
        val listOfSeries : MutableList<Series> = mutableListOf()
        for(i in 1..5) listOfSeries.add(i,Series(id=i,excersise= "Squats",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))
        for(i in 5..10) listOfSeries.add(i,Series(id=i,excersise= "Bench",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(2) ?:0.0))),
                pause = 120,
                trainingId = id))
        for(i in 10..15) listOfSeries.add(i,Series(id=i,excersise= "Row",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(3) ?:0.0))),
                pause = 120,
                trainingId = id))
        return listOfSeries
    }
     fun createWednsdaySeries(id:Int, wokrWeight:Map<Int, Double>):List<Series>{
        val listOfSeries : MutableList<Series> = mutableListOf()
        for(i in 1..5) listOfSeries.add(i,Series(id=i,excersise= "Squats",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))
        for(i in 5..10) listOfSeries.add(i,Series(id=i,excersise= "Military",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(2) ?:0.0))),
                pause = 120,
                trainingId = id))
        for(i in 10..15) listOfSeries.add(i,Series(id=i,excersise= "Deadlift",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(3) ?:0.0))),
                pause = 120,
                trainingId = id))
        return listOfSeries
    }
     fun createFridaySeries(id:Int, wokrWeight:Map<Int, Double>):List<Series>{
        val listOfSeries : MutableList<Series> = mutableListOf()
        for(i in 1..5) listOfSeries.add(i,Series(id=i,excersise= "Squats",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))
        listOfSeries.add(6,Series(id=6,excersise= "Squats",reps=5,
                weight=(wokrWeight[1]?:0.minus(((3)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))
        for(i in 7..11) listOfSeries.add(i,Series(id=i,excersise= "Bench",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(2) ?:0.0))),
                pause = 120,
                trainingId = id))
        listOfSeries.add(12,Series(id=12,excersise= "Bench",reps=5,
                weight=(wokrWeight[1]?:0.minus(((3)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))
        for(i in 13..17) listOfSeries.add(i,Series(id=18,excersise= "Row",reps=5,
                weight=(wokrWeight[1]?:0.minus(((5-i)*0.125)*(wokrWeight.get(3) ?:0.0))),
                pause = 120,
                trainingId = id))
        listOfSeries.add(18,Series(id=3,excersise= "Row",reps=5,
                weight=(wokrWeight[1]?:0.minus(((3)*0.125)*(wokrWeight.get(1) ?:0.0))),
                pause = 120,
                trainingId = id))
    return listOfSeries
    }



}