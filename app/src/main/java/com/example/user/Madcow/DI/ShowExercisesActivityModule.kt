package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.SeriesViewModel
import dagger.Module
import dagger.Provides

@Module
abstract  class ShowExercisesActivityModule {

    @Provides
    fun  provideExercisesViewModel(planApi: PlanAPI) = SeriesViewModel(planApi)
}