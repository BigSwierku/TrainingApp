package com.example.user.Madcow

import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training

/**
 * Created by User on 2018-02-15.
 */
class PlanAPI() {

private lateinit var  planCreator:PlanCreator

    fun createPlan(planType: Int){
        initliaziePlaner(planType)
        planCreator.createPlan()
    }


 fun initliaziePlaner(planType:Int){
     when (planType){
         PLAN_TYPES.MADCOW -> planCreator = MadCowPlanCreator()
     }
 }

}