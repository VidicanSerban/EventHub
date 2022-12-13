package com.example.eventhub.feature_homescreen.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.type.Date
import java.sql.Time

@Entity(tableName = "events")
data class Event(
    @PrimaryKey val uit: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "date") val date: Date?,
    @ColumnInfo(name = "time") val time: Time,
    @ColumnInfo(name = "location") val location: String = "Oradea, Romania",
    @ColumnInfo(name = "description") val description: String
)

