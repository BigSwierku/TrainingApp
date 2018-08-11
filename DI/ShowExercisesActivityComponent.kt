package com.example.user.Madcow.DI

import com.example.user.Madcow.View.ShowExercisesActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(ShowExercisesActivityModule::class))
interface ShowExercisesActivityComponent : AndroidInjector<ShowExercisesActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ShowExercisesActivity>()
}