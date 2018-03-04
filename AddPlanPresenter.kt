package com.example.user.Madcow

import javax.inject.Inject

/**
 * Created by User on 2018-01-09.
 */
class AddPlanPresenter @Inject constructor(val api:MadCowApi){

    fun calcMax(reps:Int, weight:Int):Double = weight/(1.0278-0.0278*reps)

    fun getAppi():MadCowApi=api
    fun generatePlan(maxes:Map<String,Int>){

    }







}