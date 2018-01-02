package com.example.user.Madcow

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "trainings")
 data class Training(
        @PrimaryKey(autoGenerate = true) var id: Int= 0,
        @ColumnInfo(name= "training_type") var type:Int,
        var date:Date,
        var week :Int
)