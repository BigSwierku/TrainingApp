package com.example.user.Madcow.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.user.Madcow.R
import com.example.user.Madcow.ViewModel.AddPlanViewModel
import com.example.user.Madcow.afterTextChanged
import com.example.user.Madcow.toDouble
import com.jakewharton.rxbinding.widget.RxTextView
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_plan.*
import rx.Subscription
import javax.inject.Inject

class AddPlanActivity : AppCompatActivity() {


    @Inject
    lateinit var addPlanViewModel : AddPlanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan)


        val  chestWeightEditText = RxTextView.textChanges(chestWeight).subscribe{
            if(chestWeight.text.toString().isNotEmpty() && chestReps.text.toString().isNotEmpty())
            addPlanViewModel.calcMax(chestWeight.text.toString(),chestReps.text.toString()).subscribe({it->benchMaxView.text= it.toString()})
        }
        val  deadliftWeightEditText =  RxTextView.textChanges(deadWeight).subscribe{
            if(deadWeight.text.toString().isNotEmpty() && deadReps.text.toString().isNotEmpty())
            addPlanViewModel.calcMax(deadWeight.text.toString(),deadReps.text.toString()).subscribe({it->deadliftMaxView.text= it.toString()})
        }
        val  squatWeightEditText =  RxTextView.textChanges(squatWeight).subscribe{
            if(squatWeight.text.toString().isNotEmpty() && squatReps.text.toString().isNotEmpty())
            addPlanViewModel.calcMax(squatWeight.text.toString(),squatReps.text.toString()).subscribe({it->squatMaxView.text= it.toString()})
        }
        val  militaryWeightEditText =  RxTextView.textChanges(militaryWeight).subscribe{
            if(militaryWeight.text.toString().isNotEmpty() && militaryReps.text.toString().isNotEmpty())
            addPlanViewModel.calcMax(militaryWeight.text.toString(),militaryReps.text.toString()).subscribe({it->militaryMaxView.text= it.toString()})
        }
        val  chestRepsEditText = RxTextView.textChanges(chestReps).subscribe{
            if(chestWeight.text.toString().isNotEmpty() && chestReps.text.toString().isNotEmpty())
                addPlanViewModel.calcMax(chestWeight.text.toString(),chestReps.text.toString()).subscribe({it->benchMaxView.text= it.toString()})
        }
        val  deadliftRepsEditText =  RxTextView.textChanges(deadReps).subscribe{
            if(deadWeight.text.toString().isNotEmpty() && deadReps.text.toString().isNotEmpty())
                addPlanViewModel.calcMax(deadWeight.text.toString(),deadReps.text.toString()).subscribe({it->deadliftMaxView.text= it.toString()})
        }
        val  squatRepsEditText =  RxTextView.textChanges(squatReps).subscribe{
            if(squatWeight.text.toString().isNotEmpty() && squatReps.text.toString().isNotEmpty())
                addPlanViewModel.calcMax(squatWeight.text.toString(),squatReps.text.toString()).subscribe({it->squatMaxView.text= it.toString()})
        }
        val  militaryRepsEditText =  RxTextView.textChanges(militaryReps).subscribe{
            if(militaryWeight.text.toString().isNotEmpty() && militaryReps.text.toString().isNotEmpty())
                addPlanViewModel.calcMax(militaryWeight.text.toString(),militaryReps.text.toString()).subscribe({it->militaryMaxView.text= it.toString()})
        }

        createPlanButton.setOnClickListener {
            val maxesMap = mapOf("Bench" to benchMaxView.toDouble(),
                    "Deadlift" to deadliftMaxView.toDouble(),
                    "Squat" to squatMaxView.toDouble(),
                    "Military" to militaryMaxView.toDouble())
//            addPlanViewModel.setMaxes(maxesMap)
            addPlanViewModel.generatePlan(1).doOnSuccess {   startActivity(Intent(this, AddPlanActivity::class.java))}

        }
    }

}
