package com.example.user.Madcow

import dagger.Component
import android.app.Application
import dagger.BindsInstance
import javax.inject.Singleton
import dagger.android.AndroidInjectionModule




/**
 * Created by User on 2018-01-08.
 */

//injecting modules into application class
@Singleton
@Component(modules = arrayOf(AppModule::class, AndroidInjectionModule::class,
      ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
     interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: MadCowApplication)
}

