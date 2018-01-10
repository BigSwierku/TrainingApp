package com.example.user.Madcow

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by User on 2018-01-03.
 */

//databes class
@Database(entities= arrayOf(Series::class,Training::class,TrainingWithSeries::class),version = 1)
abstract class MadcowDatabase:RoomDatabase(){
    abstract fun trainingDao(): TrainingDao
    abstract fun seriesDao(): SeriesDao
    abstract fun trainingWithSeriesDao():TrainingWithSeriesDao



}
