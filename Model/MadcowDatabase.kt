package com.example.user.Madcow.Model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.user.Madcow.Converters

/**
 * Created by User on 2018-01-03.
 */

//databes class
@Database(entities= arrayOf(Series::class, Training::class),version = 1)
@TypeConverters(Converters::class)
abstract class MadcowDatabase:RoomDatabase(){
    abstract fun trainingDao(): TrainingDao
    abstract fun seriesDao(): SeriesDao




}
