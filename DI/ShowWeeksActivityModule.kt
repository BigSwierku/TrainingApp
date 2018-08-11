package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI

import com.example.user.Madcow.ViewModel.PlanViewModel
import com.example.user.Madcow.ViewModel.WeeksViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by User on 2018-01-08.
 */


//activity stuff - dagger2.10
@Module
abstract  class ShowWeeksActivityModule {



    @Provides
     fun  provideWeeksViewModel(planApi: PlanAPI) = WeeksViewModel(planApi)
}