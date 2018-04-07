package com.example.user.Madcow.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "trainings")
 data class Training(
        @PrimaryKey(autoGenerate = true) var id: Int?=null,
        @ColumnInfo(name= "training_type") var type:Int,
        var date:java.util.Date,
        var week :Int
)