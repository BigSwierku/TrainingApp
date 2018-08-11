package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.PlanAPI
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

/**
 * Created by User on 2018-05-03.
 */
class TrainingsViewModel@Inject constructor(private val planApi: PlanAPI) {


    fun getExcersisesForTrainig(trainigId : Int):Flowable<Series>{
        planApi.getSeriesForTrainig(trainigId).distinct { it.excersise }
    }

}
