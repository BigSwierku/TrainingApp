package com.example.user.Madcow

import android.Manifest.permission_group.CALENDAR
import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.R.id.time
import io.reactivex.Flowable
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*
import javax.inject.Inject
import jdk.nashorn.internal.objects.NativeDate.getTime
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import kotlin.math


/**
 * Created by User on 2018-01-10.
 */

class MadCowApi @Inject constructor(val db: MadcowDatabase) {
    private val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            private val weightProgressPerWeek = 0.2
            private lateinit  var startingWorkingWeights : Map<String,Double>
            private val firstTrainigDate = while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) cal.add(Calendar.DATE,1) //trzeba wymienic na wbudowana funkcje cal
            fun createPlan(MmaximalWeightsForFiveReps : Map<String,Double>){
                startingWorkingWeights = MmaximalWeightsForFiveReps.mapValues{ it.value-(it.value*weightProgressPerWeek)}
                for (i in 0..9){
                    addTrainig(cal.time)
                    cal.add(Calendar.DATE,2)
                addTrainig(cal.time)
                cal.add(Calendar.DATE,2)
                addTrainig(cal.time)
                cal.add(Calendar.DATE,3)
        }
    }



    private fun addTrainig(date: Date){
        var id =db.trainingDao().insertTraining(Training(type=cal.get(Calendar.DAY_OF_WEEK,week=week,cal.time))

    }
    private fun addExcerisesPerTrainig(id:Int){
        for (excersiseName in getExercisesPerDayOfWeek(Calendar.DAY_OF_WEEK)){
            addExcersise(excersiseName,id)
        }
    }
    private fun getExercisesPerDayOfWeek(dayOfWeek:Int):List<String>{
        when(dayOfWeek){
            Calendar.MONDAY-> return listOf("Squat","Bench","Row")
            Calendar.WEDNESDAY-> return  listOf("Military","Bench","Row")
            Calendar.FRIDAY->return listOf("Squat","Bench","Row")
            else ->throw  IllegalArgumentException(" Wrong day of week for trainig!, please set monday, wednsday or friday")
        }
    }
    private fun  addExcersise(excersiseName:String,trainingId:Int){
        val workWeightForTrainig = calculateWorkWeightForTraining(cal.time)
        val seriesInExcersise :MutableList<Series> = mutableListOf()
            when(Calendar.DAY_OF_WEEK) {
                1 -> for (i in 1..5) {
                    seriesInExcersise.add(Series(excersise = excersiseName,
                                reps = 5,//shared.getRepsForDayOfWeek(training.date))
                                weight = (workWeightForTrainig - (((5 - i) * CONSTANTS.SERIES_WEIGHT_INCREASE) * workWeightForTrainig)),
                                pause = CONSATNTS.PAUSE_TIME,
                                trainingId = trainingId))
                }

                2 -> for (i in 2..5) {
                    seriesInExcersise.add(Series(excersise = excersise,
                        reps=5,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight -(((5 - i) * 0.125) * wokrWeight)),
                        pause=120,
                        trainingId = training_id))
                }
                3 -> {
                    for (i in 1..4) {
                    seriesInExcersise.add(Series(excersise = excersise,
                            reps = 5,//shared.getRepsForDayOfWeek(training.date))
                            weight = (wokrWeight -(((5 - i) * 0.125) * wokrWeight)),
                            pause = 120,
                            trainingId = training_id))
                    }
                    seriesInExcersise.add(Series(excersise = excersise,
                        reps = 3,//shared.getRepsForDayOfWeek(training.date))
                        weight = wokrWeight,
                        pause = 120,
                        trainingId = training_id))
                    seriesInExcersise.add(Series(excersise = excersise,
                        reps = 8,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight - ( 0.25 * wokrWeight)),
                        pause = 120,
                        trainingId = training_id))
                }
                else -> throw IllegalArgumentException(" Wrong day of week for trainig!, please set monday, wednsday or friday")
            }
            db.seriesDao().insertAllSeries(seriesInExcersise)
        }

    fun getWeeksInPlan(){}
    fun getTrainigsInWeek(){}
    fun getExcersisesForTraining(){}
    fun getSeriesForTrainign(){}

}