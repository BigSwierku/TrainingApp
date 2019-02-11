package com.example.user.Madcow.ViewModel

//import com.example.user.Madcow.MadCowPlanCreator
import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.UserProperities
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by User on 2018-01-09.
 */
class AddPlanViewModel @Inject constructor(private val planAPI: PlanAPI) {

    fun calcMax(reps:String, weight:String):Single<Double> {

        return Single.just(weight.toDouble() / (1.0278 - 0.0278 * reps.toDouble()))
    }
    fun setMaxes(maxes:Map<String,Double>){
        UserProperities.instance.maxWeights = maxes}

    fun generatePlan(planType:Int):Single<Boolean>{
      return   Single.fromCallable {
        planAPI.createPlan(planType)}}

    }







