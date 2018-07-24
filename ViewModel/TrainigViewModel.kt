package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.PlanAPI
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

/**
 * Created by User on 2018-05-03.
 */
class TrainigViewModel@Inject constructor(private val planApi: PlanAPI) {


    fun getExcersisesForTrainig(trainigId : Int){
        planApi.getSeriesForTrainig(trainigId)
    }

}
