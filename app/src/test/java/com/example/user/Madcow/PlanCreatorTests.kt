package com.example.user.Madcow

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.user.Madcow.Model.MadcowDatabase
import com.example.user.Madcow.Model.Series
import com.example.user.Madcow.Model.Training
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

import org.junit.runner.RunWith
import java.util.*

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.*

/**
 * Created by User on 2018-06-03.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlanCreatorTests {
    lateinit var  planCreator : Beyond531Plancreator
    lateinit var cal: Calendar
    private lateinit var mondaySecondWeekTraining: Training
    private var thirdSeriesSquatWeightSecondWeek: Double? = null
    private lateinit var mondaySecondWeekSeries: List<Series>
    private lateinit var trainigsHarmonogram : List<Training>
    private lateinit var tuesdayThirdWeekTraining : Training
    private lateinit var tuesdayThirdWeekSeries: List<Series>
    private var thirdSeriesBenchWeightThirdWeek : Double? = null

    @BeforeAll
    fun setUp() {
        planCreator = Beyond531Plancreator()

        UserProperities.instance.maxWeights= mapOf("Bench" to 100.0,"Military" to 50.0, "Squat" to 200.0, "Deadlift" to 300.0)

        trainigsHarmonogram = planCreator.createTrainigsHarmonogram()

        cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        cal.setDateToClosestMonday()
        cal.add(Calendar.DATE, 7)
        mondaySecondWeekTraining = Training(1, cal.time, 2)
        cal.add(Calendar.DATE, 8)
        tuesdayThirdWeekTraining = Training(2, cal.time, 3)

        thirdSeriesSquatWeightSecondWeek = UserProperities.instance.workingMaxWeights["Squat"]?.times(0.85)
        thirdSeriesBenchWeightThirdWeek = UserProperities.instance.workingMaxWeights["Bench"]?.times(0.95)

        mondaySecondWeekSeries = planCreator.createSeriesForTrainig(mondaySecondWeekTraining)
        tuesdayThirdWeekSeries = planCreator.createSeriesForTrainig(tuesdayThirdWeekTraining)

    }

     @BeforeEach
     fun init(){
         cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
         cal.setDateToClosestMonday()
     }

    @Nested
    @DisplayName ("Tests fro proper dates of trainings in plan")
    inner class DateOfTrainigsTests {

        @DisplayName ("Test Of first training date")
        @Test
        fun checkDateOfFirstTraining() {
            assertThat(trainigsHarmonogram[0].date, equalTo(cal.time))
        }

        @DisplayName ("Test of date of monday training in second week")
        @Test
        fun checkDateOfMondayTrainingInTwoWeeks() {
            cal.add(Calendar.DATE, 14)
            assertThat(trainigsHarmonogram[8].date, equalTo(cal.time))
        }

        @DisplayName ("Test od last training date")
        @Test
        fun checkDateOfLastTraining() {
            val daysUntillastTrainnig = 39
            cal.add(Calendar.DATE, daysUntillastTrainnig)
            assertThat(trainigsHarmonogram.last().date, equalTo(cal.time))
        }
    }


    @Nested
    @DisplayName ("Tests of monday training in second week  ")
    inner class MondayTrainingInSecondWeekTests {

        @BeforeEach
        fun init() {
            cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            cal.setDateToClosestMonday()
            cal.add(Calendar.DATE, 7)
        }

        @Test
        @DisplayName ("Verifying Weight in third series of squat")
        fun checkSquatWeight() {
            assertThat(mondaySecondWeekSeries
                    .filter { it.excersise == "Squat" }
                    .sortedBy { it.weight }[2].weight, equalTo(thirdSeriesSquatWeightSecondWeek))
        }

        @Test
        @DisplayName ("Verifying reps amount in  series of squat")
        fun checkSquatRepsAmount() {
            assertThat(mondaySecondWeekSeries
                    .filter { it.excersise == "Squat" }.size, equalTo(3))
        }

        @Test
        @DisplayName("Veryfing if last seires is AMRAP")
        fun checkAmrapFlag(){
            assertThat(mondaySecondWeekSeries.filter { it.excersise=="Squat" }[2].amrapFlag, equalTo(true))
        }

        @Test
        @DisplayName ("Verifying reps amount in  series of deadlift")
        fun checkDeadliftRepsAmount() {
            assertThat(mondaySecondWeekSeries
                    .filter { it.excersise == "Deadlift" }.size, equalTo(5))
        }

        @Test
        @DisplayName ("Verifying consistency of deadlift series")
        fun checkDeadliftWeight() {
            assertThat(mondaySecondWeekSeries
                    .filter { it.excersise == "Deadlift" }
                    .sortedBy { it.weight }[0].weight,
                    equalTo(mondaySecondWeekSeries
                            .filter { it.excersise == "Deadlift" }
                            .sortedBy { it.weight }[4].weight))

        }
    }


    @Nested
    @DisplayName ("Tests of tuesday training in third week  ")
    inner class TuesdayThirdWeekTest {


        @BeforeEach
        fun init() {
            cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            cal.setDateToClosestMonday()
            cal.add(Calendar.DATE, 15)
        }

        @Test
        @DisplayName ("Verifying Weight in third series of Bench")
        fun checkSquatWeight() {
            assertThat(tuesdayThirdWeekSeries
                    .filter { it.excersise == "Bench" }
                    .sortedBy { it.weight }[2].weight, equalTo(thirdSeriesBenchWeightThirdWeek))
        }

        @Test
        @DisplayName ("Verifying reps amount in  series of bench")
        fun checkSquatRepsAmount() {
            assertThat(tuesdayThirdWeekSeries
                    .filter { it.excersise == "Bench" }.size, equalTo(3))
        }

        @Test
        @DisplayName("Veryfing if last seires is AMRAP")
        fun checkAmrapFlag(){
            assertThat(tuesdayThirdWeekSeries.filter { it.excersise=="Bench" }[2].amrapFlag, equalTo(true))
        }

        @Test
        @DisplayName ("Verifying reps amount in  series of military press")
        fun checkDeadliftRepsAmount() {
            assertThat(tuesdayThirdWeekSeries
                    .filter { it.excersise == "Military" }.size, equalTo(5))
        }

        @Test
        @DisplayName ("Verifying consistency of military press series")
        fun checkDeadliftWeight() {
            assertThat(tuesdayThirdWeekSeries
                    .filter { it.excersise == "Military" }
                    .sortedBy { it.weight }[1].weight,
                    equalTo(tuesdayThirdWeekSeries
                            .filter { it.excersise == "Military" }
                            .sortedBy { it.weight }[4].weight))

        }
    }


        @Test
        fun creatingSeriesForTrainingTestThursdayFirstWeek() {

        }
        @Test
        fun creatingSeriesForTrainingTestFridayForthWeek() {

        }
    }


