package com.peakfinn.task5level1

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by Finn Bon on 25/05/2020.
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
