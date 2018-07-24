package com.example.user.Madcow.DI

import com.example.user.Madcow.View.AddPlanActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by User on 2018-01-09.
 */

@Subcomponent (modules = arrayOf(AddPlanActivityModule::class))
interface AddPlanActivityComponent : AndroidInjector<AddPlanActivity> {

    @Subcomponent.Builder abstract class Builder : AndroidInjector.Builder<AddPlanActivity>()
}

