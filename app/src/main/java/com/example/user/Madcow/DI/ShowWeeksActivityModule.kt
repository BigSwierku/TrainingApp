package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI

import com.example.user.Madcow.ViewModel.TrainingsViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by User on 2018-01-08.
 */


//activity stuff - dagger2.10
@Module
abstract  class ShowWeeksActivityModule {



    @Provides
     fun  provideWeeksViewModel(planApi: PlanAPI) = TrainingsViewModel(planApi)
}