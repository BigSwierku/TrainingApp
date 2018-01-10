package com.example.user.Madcow

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import android.app.Application
import javax.inject.Singleton


/**
 * Created by User on 2018-01-03.
 */

//provides context,database and daos
@Module
class AppModule() {

    @Singleton
    @Provides fun providesAppContext(application:Application) = application

    @Singleton
    @Provides
    fun providesMadcow(context: Context): MadcowDatabase =
            Room.databaseBuilder(context, MadcowDatabase::class.java, "madcow_db").build()


    @Provides
    fun providesApi(trainigDao: TrainingDao, seriesDao: SeriesDao,  trainingWithSeriesDao: TrainingWithSeriesDao) : MadCowApi = MadCowApi(trainigDao,seriesDao,trainingWithSeriesDao )



}