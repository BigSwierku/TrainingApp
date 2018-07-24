package com.example.user.Madcow.ViewModel

//import com.example.user.Madcow.MadCowPlanCreator
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.signum
import javax.inject.Inject
import io.reactivex.Flowable
import org.intellij.lang.annotations.Flow
import java.util.*



/**
 * Created by User on 2018-01-08.
 */
class PlanViewModel @Inject constructor(private val planApi: PlanAPI)  {
    fun getPlanHarmonogram():Flowable<Training>{
//       val mondayTrainigs= planApi.getTrainigs().filter { it -> it.date.day == Calendar.MONDAY}
//               .flatMap { listTrainig -> Flowable.fromIterable(listTrainig)
//               .filter{it -> it.date.day == Calendar.MONDAY}}.toList().toFlowable()



        return planApi.getTrainigs().filter { it.date.day == Calendar.MONDAY }
                .sorted { training1, training2 ->  training1.week - training2.week}
   }




}