package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.TimerViewModel
import dagger.Module
import dagger.Provides

@Module
class ShowSeriesActivityModule {

    @Provides
    fun  provideSeriesViewModel(planApi: PlanAPI) = TimerViewModel(planApi)
}