package com.example.eventhub.feature_onboarding.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val email: String,
    @ColumnInfo val password: String,
    @ColumnInfo val name: String

)