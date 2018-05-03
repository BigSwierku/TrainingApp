package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.MadCowPlanCreator
import com.example.user.Madcow.PlanAPI
import javax.inject.Inject

/**
 * Created by User on 2018-01-09.
 */
class AddPlanViewModel @Inject constructor(val planAPI: PlanAPI):ViewModel(){

    fun calcMax(reps:Int, weight:Int):Double = weight/(1.0278-0.0278*reps)


    fun generatePlan(planType:Int){
        planAPI.createPlan(planType)
    }







}