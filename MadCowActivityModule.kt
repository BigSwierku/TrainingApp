package com.example.user.Madcow

import dagger.Module
import dagger.Provides

/**
 * Created by User on 2018-01-08.
 */


//activity stuff - dagger2.10
@Module
abstract class MadCowActivityModule {



    @Provides
    fun provideMadCowPresenter(api:MadCowApi) = MadCowPresenter(api)
}