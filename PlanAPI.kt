package com.example.user.Madcow

import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

/**
 * Created by User on 2018-02-15.
 */
  class PlanAPI @Inject constructor(val db: MadcowDatabase) {

private lateinit var  planCreator:PlanCreator

      fun createPlan(planType : Int):Boolean{
        planCreator = Beyond531Plancreator()
          addTrainings()
            return true
    }

    private fun addTrainings(){
        var trainigHarmonogram = planCreator.createTrainigsHarmonogram()
        db.trainingDao().insertTrainings(trainigHarmonogram)
        insertSeriesForTrainigs(trainigHarmonogram)
    }
    private fun insertSeriesForTrainigs(trainigList:List<Training> ){
        for (training in trainigList){
            var seriesForTrainig = planCreator.createSeriesForTrainig(training)
            db.seriesDao().insertAllSeries(seriesForTrainig)
        }
    }

    fun getTrainigs(): Flowable<Training> = db.trainingDao().getTrainings()

    //fun getTrainigForDate(trainingDate : Date):Single<Training> = db.trainingDao().getTrainingForDate(trainingDate)

   // fun getTrainigById(trainingId : Int):Single<Training> = db.trainingDao().getTrainingById(trainingId)

    fun getSeriesForTrainig(trainingId : Int):Flowable<Series> = db.seriesDao().getSeriesByTraining(trainingId)

    fun getSeriesById(seriesId : Int): Single<Series> = db.seriesDao().getSeriesById(seriesId)

    fun getTrainigsForWeek(week:Int):Flowable<Training> = db.trainingDao().getTrainingsForWeek(week)



}