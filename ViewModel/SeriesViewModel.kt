package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

class SeriesViewModel@Inject constructor(private val planApi: PlanAPI) {


    fun getSeriesForExercise(trainigId : Int, exerciseName : String) = planApi.getSeriesForTrainig(trainigId)//.filter { it.excersise.equals(exerciseName) }

    }




