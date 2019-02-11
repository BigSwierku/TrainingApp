package com.example.user.Madcow

import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import java.util.*

/**
 * Created by User on 2018-05-03.
 */
abstract class PlanCreator(){
     abstract fun createSeriesForTrainig(training:Training):List<Series>
     abstract fun createTrainigsHarmonogram():MutableList<Training>
     //abstract fun addSeriesForExcersise(excersiseName:String,trainingId:Int)
}