package com.example.user.Madcow

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by User on 2018-01-09.
 */
@Subcomponent(modules = arrayOf(MadCowActivityModule::class))
interface MadCowActivityComponent : AndroidInjector<MadCowActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<MadCowActivity>()
}