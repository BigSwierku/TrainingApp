package com.example.user.Madcow

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey



@Entity(tableName = "series")
data class Series(
        @PrimaryKey(autoGenerate = true) var id:Int,
        var excersise: String,
        var reps: Int,
        var weight:Double,
        var pause : Int,
        @ColumnInfo(name = "training_id")var trainingId: Int
)