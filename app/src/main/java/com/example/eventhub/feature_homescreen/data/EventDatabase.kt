package com.example.eventhub.feature_homescreen.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eventhub.feature_onboarding.data.UserDatabase

@Database(entities = [Event::class], version = 2)
abstract class EventDatabase: RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {
        @Volatile
        private var INSTANCE: EventDatabase? = null

        fun getEventDB(context: Context): EventDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EventDatabase::class.java,
                    "events"
                ).build()
                INSTANCE = instance
                instance
            }
        }
        fun destroyEventDB(){
            INSTANCE = null
        }
    }
}