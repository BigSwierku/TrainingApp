package com.example.user.Madcow

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

/**
 * Created by User on 2018-01-03.
 */

//databes class
@Database(entities= arrayOf(Series::class,Training::class),version = 1)
@TypeConverters(Converters::class)
abstract class MadcowDatabase:RoomDatabase(){
    abstract fun trainingDao(): TrainingDao
    abstract fun seriesDao(): SeriesDao




}
