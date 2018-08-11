package com.example.user.Madcow.DI

import com.example.user.Madcow.View.ShowTrainingsActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(ShowTrainingsActivityModule::class))
interface ShowTrainingsActivityComponent : AndroidInjector<ShowTrainingsActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ShowTrainingsActivity>()
}