package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {


    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainViewModel(planApi: PlanAPI) = MainViewModel(planApi)
    }
}