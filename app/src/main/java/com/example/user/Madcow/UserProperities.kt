package com.example.user.Madcow

import javax.inject.Singleton

/**
 * Created by User on 2018-05-29.
 */
 class  UserProperities private constructor() {


    companion object {
        var  maxWeights : Map<String, Double> = mapOf("Bench" to 0.0  , "Military" to 0.0,"Squat" to  0.0 , "Deadlift" to 0.0  )

        fun getWorkingWeights() :Map<String, Double> = maxWeights.mapValues{ it.value.times(0.9) }
    }



}




