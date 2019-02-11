package com.example.user.Madcow.ViewModel

import android.content.Context
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import io.reactivex.Maybe
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class MainViewModel @Inject constructor(private val planApi: PlanAPI) {
    fun getTrainingForToday(): Maybe<Training> {
        val cal = Calendar.getInstance()
        return planApi.getTrainingForDate(cal.time)
    }

    fun checkIfHarmonogramExist() : Single<Training> = planApi.getAnyTrainig()
}