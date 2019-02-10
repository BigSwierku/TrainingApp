package com.example.user.Madcow

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import com.example.user.Madcow.ViewModel.*
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


//@RunWith(MockitoJUnitRunner::class)
class SeriesViewModelsTests {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val planApi = mock<PlanAPI>()


    @InjectMocks
    private lateinit var exerciseViewModel : ExercisesViewModel


    @InjectMocks
    private lateinit var seriesViewModel : SeriesViewModel

    private lateinit var seriesList : List<Series>

    private lateinit var testSubscriber : TestSubscriber<Series>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        seriesList = listOf(
                Series(1,"Bench",5,6.0,120,false,4),
                Series(2,"Deadlift",3,16.0,120, false,4),
                Series(4,"Squat",2,46.0,120, false,4),
                Series(7,"Squat",1,56.0,120, false,3),
                Series(9,"Bench",5,66.0,120,false,3),
                Series(3,"Bench",5,67.0,120,false,3))
        testSubscriber = TestSubscriber()

    }
    @After
    fun tearDown(){
        testSubscriber.dispose()
    }


    @Test
    fun shouldGetOneSeriesPerExercise(){
        given(planApi.getSeriesForTrainig(2)).willReturn(Flowable.fromIterable(seriesList))

        exerciseViewModel.getExcersisesForTrainig(2).subscribe(testSubscriber)
        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValueCount(3)
        //testSubscriber.ass()
    }

    @Test
    fun shouldGetSeriesWithForOneExercise(){
        given(planApi.getSeriesForTrainig(3)).willReturn(Flowable.fromIterable(seriesList.filter { it.trainingId==3 }))

        seriesViewModel.getSeriesForExercise(3,"Bench").subscribe(testSubscriber)
        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValueCount(2)
        testSubscriber.assertValues(seriesList[4],seriesList[5])
    }
}