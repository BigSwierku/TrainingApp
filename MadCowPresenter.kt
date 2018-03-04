package com.example.user.Madcow

import javax.inject.Inject

/**
 * Created by User on 2018-01-08.
 */
class MadCowPresenter @Inject constructor(val api:MadCowApi) {


    fun getAppi():MadCowApi=api



}