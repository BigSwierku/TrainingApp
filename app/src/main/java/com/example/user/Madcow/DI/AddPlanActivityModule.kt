package com.example.user.Madcow.DI

import com.example.user.Madcow.PlanAPI

import com.example.user.Madcow.ViewModel.AddPlanViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by User on 2018-01-08.
 */
@Module
class AddPlanActivityModule  {

        @Provides
        fun provideAddPlanViewModel(planApi: PlanAPI): AddPlanViewModel = AddPlanViewModel(planApi)
}