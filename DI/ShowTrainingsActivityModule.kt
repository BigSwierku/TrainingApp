package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.TrainingsViewModel
import dagger.Module
import dagger.Provides

@Module
abstract  class ShowTrainingsActivityModule {



    @Provides
    fun  provideTrainingsViewModel(planApi: PlanAPI) = TrainingsViewModel(planApi)
}