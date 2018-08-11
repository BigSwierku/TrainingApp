package com.example.user.Madcow.DI

import com.example.user.Madcow.View.AddPlanActivity
import com.example.user.Madcow.View.ShowWeeksActivity
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

}