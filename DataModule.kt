package com.example.user.Madcow

import dagger.Module
import dagger.Provides

/**
 * Created by User on 2018-01-10.
 */

@Module
class DataModule(){


@Provides
fun providesSeriesDao(database: MadcowDatabase) = database.seriesDao()

@Provides
fun providesTrainingDao(database: MadcowDatabase) = database.trainingDao()

@Provides
fun providesTrainigWithSeriesDao(database: MadcowDatabase) = database.trainingWithSeriesDao()
}