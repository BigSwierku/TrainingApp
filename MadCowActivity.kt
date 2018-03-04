package com.example.user.Madcow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject
import dagger.android.AndroidInjection


//Activity showing plan
class MadCowActivity : AppCompatActivity() {

    @Inject lateinit var madCowPresenter : MadCowPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mad_cow)



    }
}
