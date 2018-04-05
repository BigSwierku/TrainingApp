package com.example.user.Madcow.ViewModel

import com.example.user.Madcow.MadCowApi
import javax.inject.Inject

/**
 * Created by User on 2018-01-08.
 */
class MadCowViewModel @Inject constructor(val api: MadCowApi) : ViewModel() {


    fun getAppi(): MadCowApi =api



}