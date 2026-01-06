package com.yeditepe.finalexam.viewmodel
//tamam
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    var tasks = mutableStateListOf(
        Task(id = 1, title = "Final Project by Azra", isCompleted = false),
        Task(id = 2, title = "Check API by Azra", isCompleted = false)
    )

    init {
        viewModelScope.launch {
            apiTasks.value = repository.fetchTasks()
        }
    }

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val index = tasks.indexOfFirst { it.id == taskId }
        if (index != -1) {
            val task = tasks[index]
            tasks[index] = task.copy(isCompleted = !task.isCompleted)
        }
    }
}
