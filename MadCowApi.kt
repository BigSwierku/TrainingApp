package com.example.user.Madcow

import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by User on 2018-01-10.
 */

class MadCowApi @Inject constructor(val trainigDao: TrainingDao, val seriesDao: SeriesDao){




    fun getAllTrainigs(): Flowable<List<TrainingWithSeries>> =  trainigDao.getTrainings()


}