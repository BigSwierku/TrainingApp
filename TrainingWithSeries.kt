package com.example.user.Madcow

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

/**
 * Created by User on 2017-12-28.
 */

class TrainingWithSeries(
    @Embedded val training: Training,
    @Relation(parentColumn = "id", entityColumn = "training_id") val  seriesList:List<Series>)
