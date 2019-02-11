package com.example.user.Madcow.DI

import com.example.user.Madcow.View.ShowSeriesActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(ShowSeriesActivityModule::class))
interface ShowSeriesActivityComponent : AndroidInjector<ShowSeriesActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ShowSeriesActivity>()
}