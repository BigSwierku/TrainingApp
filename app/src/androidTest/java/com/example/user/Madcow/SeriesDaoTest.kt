package com.example.user.Madcow

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import io.reactivex.subscribers.TestSubscriber
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.sql.Date


@RunWith(AndroidJUnit4::class)
class SeriesDaoTest {

    lateinit var  testDb : MadcowDatabase

    @Before
    fun setUp() {
        testDb= Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), MadcowDatabase::class.java).allowMainThreadQueries().build()
        testSubscriber = TestSubscriber()
    }

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var testSubscriber : TestSubscriber<List<Training>>

    @Test
    fun insertAndUpdateSeries(){
        val training2= Training(3,  Date(2017, 12, 11),2)
        testDb.trainingDao().insertTraining(training2)
        val series = Series(1,"Squat",4,120.0,100,false,3)
        testDb.seriesDao().insertSeries(series)
        testDb.seriesDao().getSeriesById(series.id).test().assertValue(series)
        series.doneFlag=true
        testDb.seriesDao().updateSeries(series)
        testDb.seriesDao().getSeriesById(series.id).test().assertValue(series)
        series.amrapFlag=true
        testDb.seriesDao().updateSeries(series)
        testDb.seriesDao().getSeriesById(series.id).test().assertValue(series)

    }
    fun shouldInsertAndGetTrainig(){
        val training= Training(1,  Date(2017, 12, 11),1)
        testDb.trainingDao().insertTraining(training)
        testDb.trainingDao().getTrainingById(1).test().assertValue(training)//{it->it.date==training.date}
    }
    @Test
    fun insertAndGetSeriesById(){
        val training2= Training(2,  Date(2017, 12, 11),2)
        testDb.trainingDao().insertTraining(training2)
        val series = Series(1, "Bench", 5, 123.5, 120,false, 2)
        testDb.seriesDao().insertSeries(series)
        testDb.seriesDao().getSeriesById(series.id).test().assertValue(series)
    }

    @Test
    fun insertAndGetTrainigsForWeek(){
        val training8= Training(5,  Date(2017, 12, 11),2)
        val training9= Training(6,  Date(2017, 12, 11),2)

        testDb.trainingDao().insertTraining(training8)
        testDb.trainingDao().insertTraining(training9)

        testDb.trainingDao().getTrainingsForWeek(2).subscribe(testSubscriber)
        testSubscriber.assertNotComplete()
        testSubscriber.assertValue(listOf(training8,training9))// testDb.trainingDao().getTrainingsForWeek(2).test().assertComplete()

    }

    @Test
    fun shouldgetSeriesForTrainig(){

        val training2= Training(3,  Date(2017, 12, 11),2)
        testDb.trainingDao().insertTraining(training2)
        val series = Series(2, "Bench", 5, 123.5, 120,false,  3)
        val series2 = Series(3, "Bench", 6, 150.0, 120,false,  3)
        val series3 = Series(4, "Bench", 7, 150.0, 120,false,  3)

        testDb.seriesDao().insertSeries(series)
        testDb.seriesDao().insertSeries(series2)
        testDb.seriesDao().insertSeries(series3)

        //testDb.seriesDao().getSeriesByTraining(training2.id).test().assertValueCount(2)
        testDb.seriesDao().getSeriesByTraining(training2.id).test().assertValue(listOf(series,series2,series3))

    }

    @After
    fun closeDb(){
        testDb.close()
    }

}