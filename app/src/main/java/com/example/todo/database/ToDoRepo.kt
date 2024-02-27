package com.example.todo.database

import androidx.lifecycle.LiveData
import java.lang.Exception

class ToDoRepo(private val toDoDAO: ToDoDAO) {

    suspend fun insertToDo(toDoEntity: ToDoEntity) {
        try {
            toDoDAO.insertToDo(toDoEntity)
        }   catch (e:Exception) {
            println(e.message)
        }
    }

    suspend fun updateToDo(toDoEntity: ToDoEntity) {
        try {
            toDoDAO.updateToDo(toDoEntity)
        }   catch (e:Exception) {
            println(e.message)
        }
    }

    suspend fun deleteToDo(toDoId: Long) {
        try {
            toDoDAO.deleteToDo(toDoId)
        }   catch (e:Exception) {
            println(e.message)
        }
    }

    suspend fun deleteAllToDo() {
        try {
            toDoDAO.deleteAllNotes()
        } catch (e: Exception) {
            println(e.message)
        }
    }

    suspend fun getAll(): LiveData<List<ToDoEntity>>? {
        return try {
            toDoDAO.getAll()
        }   catch (e:Exception) {
            println(e.message)
            null
        }
    }

    suspend fun getAllByDone(isDone: Boolean): LiveData<List<ToDoEntity>>? {
        return try {
            toDoDAO.getAllByDone(isDone = isDone)
        }   catch (e:Exception) {
            println(e.message)
            null
        }
    }
}
