package com.example.user.Madcow.Model

import android.arch.persistence.room.*
import io.reactivex.Flowable
import org.intellij.lang.annotations.Flow
import java.util.*

/**
 * Created by User on 2017-12-28.
 */
@Dao interface TrainingDao{


    @Insert //(onConflict = REPLACE)
    fun insertTraining(training: Training)

    @Insert //(onConflict = REPLACE)
    fun insertTrainings(trainings: List<Training>)

    @Update//(onConflict = REPLACE)
    fun updateTrainig(training: Training)

    @Delete
    fun deleteTraining(training: Training)

    @Query ("select * from trainings where id = :id")
    fun getTrainingById(id: Int): Flowable<Training>


    @Query("select * from trainings where date=:date")
    fun getTrainingForDate(date: Date): Flowable<Training>

    @Query ("select * from trainings")
    fun getTrainings() : Flowable<Training>

    @Query ("select * from trainings where week =:week")
    fun getTrainingsForWeek(week:Int) : Flowable<Training>

}