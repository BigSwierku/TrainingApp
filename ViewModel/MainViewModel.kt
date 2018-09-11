package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(private val planApi: PlanAPI) {
    fun getPlanForToday(): Single<Training> {
    val cal = Calendar.getInstance()
        return planApi.getTrainigForDate(cal.time)
    }
}