package com.example.user.Madcow

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by User on 2017-12-28.
 */
@Dao interface TrainingDao{


    @Insert (onConflict = REPLACE)
    fun insertTraining(training: Training)

    @Update(onConflict = REPLACE)
    fun updateTrainig(training: Training)

    @Delete
    fun deleteTraining(training: Training)

    @Query ("select * from trainings where id = :id")
    fun getTrainingById(id: Int): Training

    @Query("select * from trainings where week =:week")
    fun  getTrainingsForWeek(week: Int) : List<Training>

}