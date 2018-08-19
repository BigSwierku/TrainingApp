package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.ExercisesViewModel
import dagger.Module
import dagger.Provides

@Module
abstract  class ShowTrainingsActivityModule {



    @Provides
    fun  provideTrainingsViewModel(planApi: PlanAPI) = ExercisesViewModel(planApi)
}