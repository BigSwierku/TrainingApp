package com.example.user.Madcow

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

/**
 * Created by User on 2018-01-10.
 */

class MadCowApi @Inject constructor(val db: MadcowDatabase) {
    val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    fun createPlan(maxMap:Map<String,Double>){
        for (i in 0..9){
            addTrainig()
        }
    }





    private fun addTrainig(data: java.sql.Date){

        db.trainingDao().insertTraining(Training(type=1,week=1,date=data))

    }

    private fun  addExcersise(wokrWeight:Double, training:Training, excersise:String){

        when(training.type) {
            1 ->for (i in 1..5) {
                db.seriesDao().insertSeries(Series(excersise = excersise,
                        reps=5,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight.minus(((5 - i) * 0.125) * wokrWeight)),
                        pause=120,
                        trainingId = training.id))
            }
            2 -> for (i in 2..5) {
                db.seriesDao().insertSeries(Series(excersise = excersise,
                        reps=5,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight.minus(((5 - i) * 0.125) * wokrWeight)),
                        pause=120,
                        trainingId = training.id))
            }
            3 -> {
                for (i in 1..4) {
                    db.seriesDao().insertSeries(Series(excersise = excersise,
                            reps = 5,//shared.getRepsForDayOfWeek(training.date))
                            weight = (wokrWeight.minus(((5 - i) * 0.125) * wokrWeight)),
                            pause = 120,
                            trainingId = training.id))
                }
                db.seriesDao().insertSeries(Series(excersise = excersise,
                        reps = 3,//shared.getRepsForDayOfWeek(training.date))
                        weight = wokrWeight,
                        pause = 120,
                        trainingId = training.id))
                db.seriesDao().insertSeries(Series(excersise = excersise,
                        reps = 8,//shared.getRepsForDayOfWeek(training.date))
                        weight = (wokrWeight.minus( 0.25 * wokrWeight)),
                        pause = 120,
                        trainingId = training.id))
            }
            else -> throw IllegalArgumentException(" Wrong day of week for trainig!, please set monday, wednsday or friday")
        }

    }

}