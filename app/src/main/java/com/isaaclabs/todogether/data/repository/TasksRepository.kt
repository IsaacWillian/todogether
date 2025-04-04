package com.isaaclabs.todogether.data.repository

import com.isaaclabs.todogether.data.model.Task

interface TasksRepository {

    fun saveNewTask(description: String, dueDate: String)

    fun getAllTasks():List<Task>
}