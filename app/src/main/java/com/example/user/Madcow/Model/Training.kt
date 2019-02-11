package com.example.user.Madcow.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Date


@Entity(tableName = "trainings")
 data class Training(
        @PrimaryKey(autoGenerate = true) var id: Int?=null,
        var date: Date,
        var week:Int
)