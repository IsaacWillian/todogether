package com.isaaclabs.todogether.ui.features.addtask

import androidx.lifecycle.ViewModel
import com.isaaclabs.todogether.data.repository.FakeTasksRepository

class AddTaskViewModel(
) :
    ViewModel() {
    private val tasksRepository = FakeTasksRepository

    fun saveNewTask(id: Int?,description: String, dueDate: String) {
        if(id == null) {
            tasksRepository.saveNewTask(description, dueDate)
        } else {
                tasksRepository.updateTask(id,description,dueDate)
        }

    }

    fun getTask(taskId: Int) = tasksRepository.getTask(taskId)
}