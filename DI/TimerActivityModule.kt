package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.TimerViewModel
import dagger.Module
import dagger.Provides

@Module
abstract  class TimerActivityModule {


    @Provides
    fun  provideTimerViewModel(planApi: PlanAPI) = TimerViewModel(planApi)
}