package com.example.user.Madcow

import com.example.user.Madcow.Model.MadcowDatabase
import java.util.*

/**
 * Created by User on 2018-05-03.
 */
abstract class PlanCreator(){
     abstract fun createPlan()
     abstract fun addTrainig()
     abstract fun addSeriesForExcersise(excersiseName:String,trainingId:Int)
}