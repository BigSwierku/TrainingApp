package com.example.user.Madcow

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey



@Entity(tableName = "series",
        foreignKeys = arrayOf(ForeignKey(entity = Training::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("training_id"),
        onDelete = ForeignKey.CASCADE)))
data class Series(
        @PrimaryKey(autoGenerate = true) var id:Int,
        var excersise: String,
        var reps: Int,
        var weight:Double,
        var pause : Int,
        @ColumnInfo(name = "training_id")var trainingId: Int
)
