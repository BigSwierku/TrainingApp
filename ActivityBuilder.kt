package com.example.user.Madcow

import dagger.Module
import dagger.android.ContributesAndroidInjector



/**
 * Created by User on 2018-01-09.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MadCowActivityModule::class))
    internal abstract fun bindMadCowActivity(): MadCowActivity

    @ContributesAndroidInjector(modules = arrayOf(AddPlanActivityModule::class))
    internal abstract fun bindAddPlanActivity(): AddPlanActivity

}