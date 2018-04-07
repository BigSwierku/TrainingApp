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


/**
 * Created by User on 2018-01-10.
 */

class MadCowApi @Inject constructor(val db: MadcowDatabase) {
    val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    private lateinit   var  startMap : Map<String,Double>
    fun createPlan(maxMap : Map<String,Double>){
        startMap = maxMap.mapValues{ it.value-(it.value*0.2)}
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) cal.add(Calendar.DATE,1)
        for (i in 0..9){
                addTrainig(1,i+1,cal.time)
                cal.add(Calendar.DATE,2)
                addTrainig(2,i+1,cal.time)
                cal.add(Calendar.DATE,2)
                addTrainig(3,i+1,cal.time)
                cal.add(Calendar.DATE,3)
        }
    }


    private fun addTrainig(type:Int,week:Int,data: Date){

        var id =db.trainingDao().insertTraining(Training(type=type,week=week,date=data))
        addExcersise(startMap.get("Bench"),id,"Bench",type)
    }

    private fun  addExcersise(wokrWeight:Double, training_id:Int, excersise:String,training_type:Int){
    val listOfSeries :MutableList<Series> = mutableListOf()
        when(training_type) {
            1 ->for (i in 1..5) {
                listOfSeries.add(Series(excersise = excersise,
                        reps=5,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight.minus(((5 - i) * 0.125) * wokrWeight)),
                        pause=120,
                        trainingId = training_id))
            }
            2 -> for (i in 2..5) {
                listOfSeries.add(Series(excersise = excersise,
                        reps=5,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight.minus(((5 - i) * 0.125) * wokrWeight)),
                        pause=120,
                        trainingId = training_id))
            }
            3 -> {
                for (i in 1..4) {
                    listOfSeries.add(Series(excersise = excersise,
                            reps = 5,//shared.getRepsForDayOfWeek(training.date))
                            weight = (wokrWeight.minus(((5 - i) * 0.125) * wokrWeight)),
                            pause = 120,
                            trainingId = training_id))
                }
                listOfSeries.add(Series(excersise = excersise,
                        reps = 3,//shared.getRepsForDayOfWeek(training.date))
                        weight = wokrWeight,
                        pause = 120,
                        trainingId = training_id))
                listOfSeries.add(Series(excersise = excersise,
                        reps = 8,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight.minus( 0.25 * wokrWeight)),
                        pause = 120,
                        trainingId = training_id))
            }
            else -> throw IllegalArgumentException(" Wrong day of week for trainig!, please set monday, wednsday or friday")
        }
        db.seriesDao().insertAllSeries(listOfSeries)
    }

}