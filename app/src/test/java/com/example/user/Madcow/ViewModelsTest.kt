package com.example.user.Madcow

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.user.Madcow.Model.Series

import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.PlanAPI
import com.example.user.Madcow.ViewModel.*
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.subscribers.TestSubscriber
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.sql.Timestamp
import java.time.LocalDate
import java.sql.Date


//@RunWith(MockitoJUnitRunner::class)
class ViewModelsTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val planApi = mock<PlanAPI>()

    @InjectMocks
    private lateinit var addPlanViewModel : AddPlanViewModel

    @InjectMocks
    private lateinit var planViewModel :PlanViewModel

    @InjectMocks
    private lateinit var trainigViewModel : TrainingsViewModel



    private lateinit var trainingList : List<Training>


    private lateinit var testSubscriber :TestSubscriber<Training>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        trainingList = listOf(
                Training(1,Date(118,7,20) ,1),
                Training(2, Date(118,7,23),1),
                Training(3, Date(118,7,27),2),
                Training(4, Date(118,7,30),2),
                Training(5, Date(118,8,3),3),
                Training(6, Date(118,8,6),3))

        testSubscriber = TestSubscriber()

    }
    @After
    fun tearDown(){
        testSubscriber.dispose()
    }

    @Test
    fun shouldGetMondayTrainingOfEveryWeek(){
        given(planApi.getTrainigs()).willReturn(Flowable.fromIterable(trainingList))
        planViewModel.getPlanHarmonogram().subscribe(testSubscriber)
        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValueCount(3)
        testSubscriber.assertValues(trainingList[0],trainingList[2],trainingList[4])

    }

    @Test
    fun ShouldGetTrainigsInSecondWeek(){
        given(planApi.getTrainigsForWeek(2)).willReturn(Flowable.fromIterable(trainingList.filter { it.week==2 }))

        trainigViewModel.getTrainigsForWeek(2).subscribe(testSubscriber)
        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValueCount(2)
        testSubscriber.assertValues(trainingList[2],trainingList[3])

    }




}