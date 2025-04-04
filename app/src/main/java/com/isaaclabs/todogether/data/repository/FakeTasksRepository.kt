package com.isaaclabs.todogether.data.repository

import com.isaaclabs.todogether.data.model.Task

object FakeTasksRepository {
    private val tasks = mutableListOf<Task>()

    fun updateTask(id: Int, description: String, dueDate: String){
        tasks.find { it.id == id }?.let {
            tasks.remove(it)
            tasks.add(it.copy(description = description, dueDate = dueDate))
        }
    }

    fun saveNewTask(description: String, dueDate: String) {
        tasks.add(Task(id = tasks.size, description = description, dueDate = dueDate, checked = false ))
    }

    fun getAllTasks(): List<Task> {
        return tasks
    }

    fun getTask(id: Int) = tasks.find { it.id == id }

    fun updateTaskState(checked: Boolean, taskId: Int) {
        val task = tasks.find { it.id == taskId }
        tasks.remove(task)
        tasks.add(task!!.copy(checked = checked))
    }
}