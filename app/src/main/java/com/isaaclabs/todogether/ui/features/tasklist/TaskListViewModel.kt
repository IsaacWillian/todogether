package com.isaaclabs.todogether.ui.features.tasklist

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.isaaclabs.todogether.data.model.TaskState
import com.isaaclabs.todogether.data.repository.FakeTasksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskListViewModel(): ViewModel(),LifecycleObserver {

    private val tasksRepository = FakeTasksRepository

    private val _tasksState = MutableStateFlow(TaskState(emptyList()))
    val taskState: StateFlow<TaskState> = _tasksState.asStateFlow()

    init {
        getAllTasks()
    }

    fun getAllTasks() {
        _tasksState.value = TaskState(tasksRepository.getAllTasks())
    }

    fun updateTaskState(checked: Boolean, taskId: Int) {
        tasksRepository.updateTaskState(checked,taskId)
        getAllTasks()
    }


}