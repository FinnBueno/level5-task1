package com.peakfinn.task5level1

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Finn Bon on 25/05/2020.
 */
@Parcelize
@Entity(tableName = "Note")
data class Note(
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "text")
    var text: String,

    @ColumnInfo(name = "lastUpdated")
    var lastUpdated: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable