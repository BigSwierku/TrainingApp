package com.example.user.Madcow

import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by User on 2018-01-10.
 */

class MadCowApi @Inject constructor(val db:MadcowDatabase) {

    fun getAllTrainigs(): Flowable<List<Training>> = db.trainingDao().getTrainings()
    fun setSeries(series: Series) {
        db.seriesDao() .insertSeries(series)
    }

    fun setTraining(trainig: Training) {
        db.trainingDao().insertTraining(trainig)
    }

    fun getSeries(id: Int) {
        db.seriesDao().getSeriesById(id)
    }

    fun getSeriesForTrainig(trainigId: Int): Flowable<List<Series>> = db.seriesDao().getSeriesByTraining(trainigId)
}