package com.example.user.Madcow

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Created by User on 2018-01-02.
 */
@Dao
interface TrainingWithSeriesDao {

    @Query("SELECT * from training")
    fun getTraingsSeries(): List<TrainingWithSeries>

    @Query("SELECT * from training where training_id=:training_id")
    fun getSeriesForTrainig(trainig: Training): List<Series>
}