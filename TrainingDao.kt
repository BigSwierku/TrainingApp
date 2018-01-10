package com.example.user.Madcow

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import io.reactivex.Flowable

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
    fun getTrainingById(id: Int): Flowable<Training>

    @Query("select * from trainings where week =:week")
    fun  getTrainingsForWeek(week: Int) : Flowable<List<Training>>

    @Query ("select * from trainings")
    fun getTrainings() : Flowable<List<Training>>

}