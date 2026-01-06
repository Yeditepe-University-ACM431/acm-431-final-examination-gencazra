package com.yeditepe.finalexam.repository

import com.yeditepe.finalexam.api.TaskApi
import com.yeditepe.finalexam.model.Task
//burası da tamam
class TaskRepository(private val api: TaskApi) {

    suspend fun fetchTasks(): List<Task> {
        // TODO 1: Call API
        // TODO 2: Convert TaskDto list to Task list
        val dtoList = api.getTasks()
        return dtoList.map { Task(it.id, it.title, it.completed) }
        return TODO("Provide the return value")
    }
}
