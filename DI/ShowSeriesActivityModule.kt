package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.SeriesViewModel
import dagger.Module
import dagger.Provides

@Module
abstract  class ShowSeriesActivityModule {



    @Provides
    fun  provideSeriesViewModel(planApi: PlanAPI) = SeriesViewModel(planApi)
}