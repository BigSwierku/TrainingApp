package com.example.user.Madcow

import android.arch.persistence.room.*

/**
 * Created by User on 2018-01-02.
 */
@Dao interface SeriesDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(series: Series)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateSeries(series: Series)

    @Delete
    fun deleteSeries(series: Series)

    @Query ("select * from series where id = :id")
    fun getSeriesById(id: Int): Series

    //@Query ("select * from series where training_id=:")
}

