package com.example.user.Madcow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import javax.inject.Inject

class AddPlanActivity : AppCompatActivity() {


    @Inject
    lateinit var madCowPresenter : MadCowPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan)
        madCowPresenter.generateplan(Map<String,Int>)
    }

}
