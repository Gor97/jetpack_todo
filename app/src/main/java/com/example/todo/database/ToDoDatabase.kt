package com.example.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ToDoEntity::class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun todoDAO(): ToDoDAO

    companion object {
        private var instance: ToDoDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ToDoDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, ToDoDatabase::class.java,
                    "TODO_DATABASE"
                )
                    .build()
                println("database created")
            }
            return instance!!
        }

    }
}