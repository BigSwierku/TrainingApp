package com.example.user.Madcow.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.user.Madcow.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_new_plan.setOnClickListener { startActivity(Intent(this, AddPlanActivity::class.java)) }
        check_existing_plan.setOnClickListener { startActivity(Intent(this, ShowWeeksActivity::class.java)) }
        show_today_training.setOnClickListener {  }

    }
}
