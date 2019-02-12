package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainViewModel(planApi: PlanAPI) = MainViewModel(planApi)
}