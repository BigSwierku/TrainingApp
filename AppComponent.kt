package com.example.user.Madcow

import dagger.Component
import android.app.Application
import dagger.BindsInstance



/**
 * Created by User on 2018-01-08.
 */

//injecting modules into application class
@Component(modules = arrayOf(AppModule::class,
        MadCowActivityModule::class, AddPlanActivityModule::class,DataModule::class))
interface AppComponent {

    @Component.Builder
     interface Builder {
        @BindsInstance
        fun application(application: MadCowApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: MadCowApplication)
}

