package com.hydroponicglass.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonTable::class], version = 1)
abstract class PersonDatabase: RoomDatabase(){
    abstract fun personDao(): PersonDao

    companion object {
        private var INSTANCE: PersonDatabase? = null

        fun GetInstance(context: Context): PersonDatabase? {
            if (INSTANCE == null) {
                // synchronized : Create Coroutine
                synchronized(PersonDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        PersonDatabase::class.java, "db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun DestroyInstance() {
            INSTANCE = null
        }
    }
}