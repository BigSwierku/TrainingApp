package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.PlanAPI
import javax.inject.Inject

class TimerViewModel @Inject constructor(private val planApi: PlanAPI) {

    fun getPauseForSeries(seriesId : Int){
        planApi.getSeriesById(seriesId)
    }
}