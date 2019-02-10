package com.example.user.Madcow

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.Model.TrainingDao
import com.example.user.Madcow.ViewModel.AddPlanViewModel
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Flowable
import io.reactivex.subscribers.TestSubscriber
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import java.sql.Date

class PlanAPITest{

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val db = mock<MadcowDatabase>()
    private val trainingDAO = mock<TrainingDao>()

    private lateinit var trainingList : List<Training>



    private lateinit var testSubscriber :TestSubscriber<Training>

    @InjectMocks
    private lateinit var planApi : PlanAPI

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        trainingList = listOf(
                Training(1, Date(118,7,20) ,1),
                Training(2, Date(118,7,23),1),
                Training(3, Date(118,7,27),2)
               // Training(4, Date(118,7,30),2),
               // Training(5, Date(118,8,3),3),
               // Training(6, Date(118,8,6),3)
                )

        testSubscriber = TestSubscriber()

    }
    @After
    fun tearDown(){
        testSubscriber.dispose()
    }

    @Test
    fun shouldGetTrainigs(){
        given(trainingDAO.getTrainings()).willReturn(Flowable.just(trainingList))
        given(db.trainingDao()).willReturn(trainingDAO)

        planApi.getTrainigs().subscribe(testSubscriber)
        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValueCount(3)
        testSubscriber.assertValues(trainingList[0],trainingList[1],trainingList[2])

    }





}