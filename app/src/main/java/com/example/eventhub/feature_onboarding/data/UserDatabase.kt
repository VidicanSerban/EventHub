package com.example.eventhub.feature_onboarding.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase?{
            if(INSTANCE == null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "users.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}