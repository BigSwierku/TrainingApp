package com.example.user.Madcow

import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import java.sql.Time
import java.util.*
import javax.inject.Inject

/**
 * Created by User on 2018-05-21.
 */
class Beyond531Plancreator() :PlanCreator() {
    private val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    private var startingWeek: Int = 0


    override fun createTrainigsHarmonogram():MutableList<Training>{
       cal.setDateToClosestMonday()
       startingWeek = cal.get(Calendar.WEEK_OF_YEAR) -1
       return createCycle()

   }

    private fun createCycle():MutableList<Training>{
         var  trainigHarmonogram : MutableList<Training> = mutableListOf()
        for (i in 0..23) {
            trainigHarmonogram.add(Training(date = cal.getTime(),week = cal.get(Calendar.WEEK_OF_YEAR) - startingWeek ) )
            moveDateToNextTrainig()
        }
        return trainigHarmonogram

    }

    private fun moveDateToNextTrainig() {
        when (cal.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY, Calendar.THURSDAY -> cal.add(Calendar.DATE, 1)
            Calendar.TUESDAY -> cal.add(Calendar.DATE, 2)
            Calendar.FRIDAY -> cal.add(Calendar.DATE, 3)
        }
    }


    override fun  createSeriesForTrainig(training : Training):List<Series>{
        val seriesInExcersise: MutableList<Series> = mutableListOf()
        cal.time=training.date
        var excersiseList = getExercisesPerDayOfWeek()//TODO changing this to take trainign and add tae fot trainig date or not
        increaseWeightifNecessary()
        when (training.week)  {
            1,4 -> {
                for (i in 1..3) {
                    seriesInExcersise.add(Series(excersise = excersiseList[0],
                            reps = 3,
                            weight = ((0.6 + (i* 0.1)) * (UserProperities.instance.workingMaxWeights.getValue(excersiseList[0]) )).roundToThirdPlace(),
                            pause = 120,
                            trainingId = training.id))
                }
                for (i in 1..5) {
                    seriesInExcersise.add(Series(excersise = excersiseList[1],
                            reps = 3,//shared.getRepsForDayOfWeek(training.date))
                            weight = (0.9 * (UserProperities.instance.workingMaxWeights.getValue(excersiseList[0]))).roundToThirdPlace(),
                            pause = 120,
                            trainingId = training.id))
                }
            }

            2,5 -> {
                for (i in 1..3) {
                    seriesInExcersise.add(Series(excersise = excersiseList[0],
                            reps = 5,
                            weight = ((0.55 + (i*0.1)) * (UserProperities.instance.workingMaxWeights.getValue(excersiseList[0]))).roundToThirdPlace(),
                            pause = 120,
                            trainingId = training.id))
                }
                for (i in 1..5) {
                    seriesInExcersise.add(Series(excersise = excersiseList[1],
                            reps = 5,//shared.getRepsForDayOfWeek(training.date))
                            weight = (0.8 * (UserProperities.instance.workingMaxWeights.getValue(excersiseList[1]))).roundToThirdPlace(),
                            pause = 120,
                            trainingId = training.id))
                }
            }

            3,6->{
                for (i in 5 downTo 1 step 2) {
                seriesInExcersise.add(Series(excersise = excersiseList[0],
                        reps = i,
                        weight = ((1.0 - (i*0.05)) * (UserProperities.instance.workingMaxWeights.getValue(excersiseList[0]))).roundToThirdPlace(),
                        pause = 120,
                        trainingId = training.id))
            }
                for (i in 1..5) {
                    seriesInExcersise.add(Series(excersise = excersiseList[1],
                            reps = 3,//shared.getRepsForDayOfWeek(training.date))
                            weight = (0.9 * (UserProperities.instance.workingMaxWeights.getValue(excersiseList[1]))).roundToThirdPlace(),
                            pause = 120,
                            trainingId = training.id))
                }
            }

        }
        return seriesInExcersise
    }
    private fun getExercisesPerDayOfWeek(): List<String> {
        when (cal.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY, Calendar.THURSDAY -> return listOf("Squat", "Deadlift")
            Calendar.TUESDAY, Calendar.FRIDAY -> return listOf("Military", "Bench")
            else -> throw  IllegalArgumentException(" Wrong day of week for trainig ${Calendar.DAY_OF_WEEK}! , please set monday, wednsday or friday")
        }
    }
    private fun increaseWeightifNecessary(){
        if((cal.get(Calendar.WEEK_OF_YEAR) - startingWeek ) ==4)
        UserProperities.instance.workingMaxWeights.values.plus(2.5)
    }


}

