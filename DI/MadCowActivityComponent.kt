package com.example.user.Madcow.DI

import com.example.user.Madcow.View.ShowWeeksActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by User on 2018-01-09.
 */
@Subcomponent(modules = arrayOf(MadCowActivityModule::class))
interface MadCowActivityComponent : AndroidInjector<ShowWeeksActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ShowWeeksActivity>()
}