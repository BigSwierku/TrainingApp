package com.example.user.Madcow

import android.app.Activity
import dagger.Binds
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by User on 2018-01-09.
 */

@Subcomponent (modules = arrayOf(AddPlanActivityModule::class))
interface AddPlanActivityComponent : AndroidInjector<AddPlanActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<AddPlanActivity>()
}

