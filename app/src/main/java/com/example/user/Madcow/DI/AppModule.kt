package com.example.user.Madcow.DI

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import android.app.Application
import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.PlanAPI
import javax.inject.Singleton


/**
 * Created by User on 2018-01-03.
 */

//provides context,database and daos
@Module
class AppModule() {



    @Provides
    fun provideContext(application:Application): Context = application



    @Singleton
    @Provides
    fun providesMadcow( context: Context): MadcowDatabase =
            Room.databaseBuilder(context, MadcowDatabase::class.java, "madcow_db").build()

    @Singleton
    @Provides
    fun providesMadcowApi(database: MadcowDatabase): PlanAPI = PlanAPI(database)







}