package com.example.user.Madcow.DI

import com.example.user.Madcow.View.ShowWeeksActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by User on 2018-01-09.
 */
@Subcomponent(modules = arrayOf(ShowWeeksActivityModule::class))
interface ShowWeeksActivityComponent : AndroidInjector<ShowWeeksActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<ShowWeeksActivity>()
}