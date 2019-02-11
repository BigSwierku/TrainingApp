package com.example.user.Madcow

import android.arch.persistence.room.TypeConverter
import java.util.Date

//import jdk.nashorn.internal.objects.NativeDate.getTime



/**
 * Created by User on 2018-01-11.
 */
class Converters(){

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return (if (date == null) null else date.time)
    }
}