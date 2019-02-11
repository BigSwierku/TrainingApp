package com.example.user.Madcow

import android.app.Activity
import android.app.Application
import com.example.user.Madcow.DI.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by User on 2018-01-08.
 */


//injecting activity injector into applicatiob
class MadCowApplication: Application(), HasActivityInjector {

    @Inject lateinit var  activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }
}