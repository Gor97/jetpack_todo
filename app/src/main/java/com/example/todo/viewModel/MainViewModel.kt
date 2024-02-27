package com.example.todo.viewModel

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import com.example.todo.database.ToDoDatabase
import com.example.todo.database.ToDoEntity
import com.example.todo.database.ToDoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val repository: ToDoRepo

    private val _textState = mutableStateOf("")
    val textState: State<String> = _textState

    init {
        val todoDB = ToDoDatabase.getInstance(application).todoDAO()
        repository = ToDoRepo(todoDB)
    }

    fun updateText(newText: String) {
        _textState.value = newText
    }

    fun initDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertToDo(ToDoEntity(1, "asdf", false))
            repository.insertToDo(ToDoEntity(2, "ghdhj", false))
            repository.insertToDo(ToDoEntity(3, "sdgf", true))
            repository.insertToDo(ToDoEntity(4, " wertwet ", false))

        }
    }
}