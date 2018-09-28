package com.example.user.Madcow.DI

import com.example.user.Madcow.View.TimerActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = arrayOf(TimerActivityModule::class))
interface TimerActivityComponent : AndroidInjector<TimerActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<TimerActivity>()
}