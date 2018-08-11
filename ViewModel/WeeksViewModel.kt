package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by User on 2018-05-03.
 */
class WeeksViewModel@Inject constructor(private val planApi: PlanAPI){


    fun getTrainigsForWeek(week : Int):Flowable<Training> {
       return planApi.getTrainigsForWeek(week)
    }
}