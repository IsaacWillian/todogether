package com.isaaclabs.todogether.data.repository

import com.isaaclabs.todogether.data.model.Task

class TasksRepositoryImpl:TasksRepository {
    private val tasks = mutableListOf<Task>()

    override fun saveNewTask(description: String, dueDate: String) {
        tasks.add(Task(id = tasks.size, description = description, dueDate = dueDate, checked = false ))
    }

    override fun getAllTasks(): List<Task> {
        return tasks
    }

}