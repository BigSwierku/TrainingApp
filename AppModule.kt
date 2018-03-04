package com.example.user.Madcow

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import android.app.Application
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by User on 2018-01-03.
 */

//provides context,database and daos
@Module
class AppModule() {

    //@Singleton
   // @Provides
   //fun providesApplication(application:MadCowApplication) = application

    @Provides
    fun provideContext(application:Application): Context = application

  //  @Singleton
  //  @Provides
  //  @Named("testDB")
   // fun provideTestDB( context: Context): MadcowDatabase =
      //      Room.inMemoryDatabaseBuilder(context, MadcowDatabase::class.java).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun providesMadcow( context: Context): MadcowDatabase =
            Room.databaseBuilder(context, MadcowDatabase::class.java, "madcow_db").build()

@Provides
fun providesMadcowApi(database:MadcowDatabase):MadCowApi = MadCowApi(database)




}