package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.MadCowPlanCreator
import javax.inject.Inject

/**
 * Created by User on 2018-01-08.
 */
class MadCowViewModel @Inject constructor(val planCreator: MadCowPlanCreator) : ViewModel() {


    fun getAppi(): MadCowPlanCreator = planCreator



}