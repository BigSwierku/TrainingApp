package com.example.user.Madcow.Model

import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import org.intellij.lang.annotations.Flow
import java.util.*

/**
 * Created by User on 2017-12-28.
 */
@Dao interface TrainingDao{


    @Insert //(onConflict = REPLACE)
    fun insertTraining (training: Training) :Long

    @Insert //(onConflict = REPLACE)
    fun insertTrainings(trainings: List<Training>)

    @Update//(onConflict = REPLACE)
    fun updateTrainig(training: Training)

    @Delete
    fun deleteTraining(training: Training)

    @Query ("select * from trainings where id = :id")
    fun getTrainingById(id: Int): Flowable<Training>


    @Query("select * from trainings where date=:date")
    fun getTrainingForDate(date: Date): Maybe<Training>

    @Query ("select * from trainings")
    fun getTrainings() : Flowable<List<Training>>

    @Query ("select * from trainings where week =:week")
    fun getTrainingsForWeek(week:Int) : Flowable<List<Training>>

    @Query("SELECT * FROM trainings LIMIT 1")
    fun getAnyTrainig(): Single<Training>

}