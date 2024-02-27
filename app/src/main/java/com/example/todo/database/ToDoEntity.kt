package com.example.todo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TODO_TABLE")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = false) val id: Long? = null,
    val text: String,
    val done: Boolean
)