package com.example.eventhub.feature_onboarding.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        private var USERDB: UserDatabase? = null

        fun createUserDB(context: Context): UserDatabase?{
            if(USERDB == null){
                synchronized(UserDatabase::class){
                    USERDB = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "users.db").allowMainThreadQueries().build()
                }
            }
            return USERDB
        }

        fun destroyInstance(){
            USERDB = null
        }
    }
}