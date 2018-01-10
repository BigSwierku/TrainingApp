package com.example.user.Madcow

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by User on 2018-01-08.
 */
@Module
abstract class AddPlanActivityModule {




    @Provides
     fun provideAddPlanPresenter(api : MadCowApi): AddPlanPresenter = AddPlanPresenter(api)



}