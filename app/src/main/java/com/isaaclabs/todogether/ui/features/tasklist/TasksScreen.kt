package com.isaaclabs.todogether.ui.features.tasklist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.isaaclabs.todogether.data.model.TaskState
import com.isaaclabs.todogether.ui.theme.DarkBlue80

@Composable
fun TaskScreenRoute(
    taskListViewModel: TaskListViewModel,
    navigateToAddTaskScreen: (String?) -> Unit
){
    val state by taskListViewModel.taskState.collectAsStateWithLifecycle()

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            taskListViewModel.getAllTasks()
        }
    }

    TasksScreen(
        state,
        navigateToAddTaskScreen = navigateToAddTaskScreen,
        updateTaskState = { checked, taskId ->
            taskListViewModel.updateTaskState(
                checked,
                taskId
            )
        }
    )
}


@Composable
fun TasksScreen(
    state: TaskState,
    navigateToAddTaskScreen: (String?) -> Unit,
    updateTaskState: (Boolean, Int) -> Unit
) {
    Scaffold(
        containerColor = Color.Black,
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToAddTaskScreen(null) },
                containerColor = DarkBlue80,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "add new task")
            }
        }, content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Tasks",
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.White,
                    modifier = Modifier.padding(top = 24.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TasksList(state.data,navigateToAddTaskScreen,updateTaskState)
            }
        })
}

@Preview
@Composable
fun TasksScreenPreview() {
    TasksScreen(state = TaskState(emptyList()) , navigateToAddTaskScreen = {} , updateTaskState = { _, _ ->})
}