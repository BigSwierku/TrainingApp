package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.MadCowApi
import javax.inject.Inject

/**
 * Created by User on 2018-01-09.
 */
class AddPlanViewModel @Inject constructor(val api: MadCowApi):ViewModel(){

    fun calcMax(reps:Int, weight:Int):Double = weight/(1.0278-0.0278*reps)


    fun generatePlan(maxes:Map<String,Int>){

    }







}