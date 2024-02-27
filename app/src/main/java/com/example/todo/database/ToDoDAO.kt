package com.example.todo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(todo: ToDoEntity)

    @Update
    fun updateToDo(todo: ToDoEntity)

    @Query("DELETE FROM TODO_TABLE WHERE id = :todoId")
    fun deleteToDo(todoId: Long)

    @Query("delete from TODO_TABLE")
    fun deleteAllNotes()

    @Query("SELECT * FROM TODO_TABLE WHERE done = :isDone")
    fun getAllByDone(isDone: Boolean): LiveData<List<ToDoEntity>>

    @Query("SELECT * FROM TODO_TABLE")
    fun getAll(): LiveData<List<ToDoEntity>>
}