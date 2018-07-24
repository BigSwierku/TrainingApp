package com.example.user.Madcow

import javax.inject.Singleton

/**
 * Created by User on 2018-05-29.
 */
 class  UserProperities private constructor() {


    init {}

    private object Holder {
        val INSTANCE = UserProperities()
    }

    companion object {
        val instance: UserProperities by lazy { Holder.INSTANCE }
    }
    var    maxWeights : MutableMap<String, Double> = mutableMapOf("Bench" to 0.0  , "Military" to 0.0,"Squat" to  0.0 , "Deadlift" to 0.0  )

    var    workingMaxWeights = maxWeights.mapValues({ it.value.times(0.9) })
        get(): Map<String, Double> = maxWeights.mapValues({ it.value.times(0.9) })

}




