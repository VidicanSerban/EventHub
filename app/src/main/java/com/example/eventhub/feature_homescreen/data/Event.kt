package com.example.eventhub.feature_homescreen.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.type.Date
import java.sql.Time

@Entity(tableName = "events")
data class Event(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "description") val description: String?
)

