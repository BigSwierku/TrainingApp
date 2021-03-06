package com.example.user.Madcow.ViewModel

//import com.example.user.Madcow.MadCowPlanCreator
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.signum
import javax.inject.Inject
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import java.util.*



/**
 * Created by User on 2018-01-08.
 */
class PlanViewModel @Inject constructor(private val planApi: PlanAPI) {
    fun getPlanHarmonogram(): Flowable<Training> {

        return planApi.getTrainigs()
                .filter { it.date.day == Calendar.MONDAY }
        //.sorted  { training1, training2 ->  training1.week - training2.week}}
    }
    }





