package com.example.user.Madcow.Model

import android.arch.persistence.room.*
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by User on 2018-01-02.
 */
@Dao interface SeriesDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(series: Series)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSeries(seriesList: List<Series>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateSeries(series: Series)

    @Delete
    fun deleteSeries(series: Series)

    @Query ("select * from series where id = :id")
    fun getSeriesById(id: Int?): Flowable<Series>

    @Query ("select * from series where training_id=:training_id")
    fun getSeriesByTraining(training_id:Int?): Flowable<List<Series>>
}

