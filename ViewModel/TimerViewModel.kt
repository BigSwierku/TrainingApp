package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.PlanAPI
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class TimerViewModel @Inject constructor(private val planApi: PlanAPI) {

    fun getSeriesById(seriesId : Int): Single<Series> = planApi.getSeriesById(seriesId)
    fun markSeriesAsDone(series : Series): Single<Int> = planApi.updateSeries(series)
}