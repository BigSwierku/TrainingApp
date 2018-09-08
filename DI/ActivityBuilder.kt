package com.example.user.Madcow.DI

import com.example.user.Madcow.View.*
import dagger.Module
import dagger.android.ContributesAndroidInjector



/**
 * Created by User on 2018-01-09.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(ShowWeeksActivityModule::class))
    internal abstract fun bindShowWeeksActivity(): ShowWeeksActivity

    @ContributesAndroidInjector(modules = arrayOf(AddPlanActivityModule::class))
    internal abstract fun bindAddPlanActivity(): AddPlanActivity

    @ContributesAndroidInjector(modules = arrayOf(ShowTrainingsActivityModule::class))
    internal abstract fun bindShowTrainingsActivity(): ShowTrainingsActivity

    @ContributesAndroidInjector(modules = arrayOf(ShowExercisesActivityModule::class))
    internal abstract fun bindShowExerciseActivity(): ShowExercisesActivity


    @ContributesAndroidInjector(modules = arrayOf(ShowSeriesActivityModule::class))
    internal abstract fun bindShowSeriesActivity(): ShowSeriesActivity

}