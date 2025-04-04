package com.isaaclabs.todogether.ui.features.tasklist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaaclabs.todogether.data.model.Task

@Composable
fun TasksList(tasks: List<Task>,navigateToAddTaskScreen: (String?) -> Unit, updateTaskState: (Boolean, Int) -> Unit) {
    LazyColumn {
        items(tasks, { it.id }) { task ->
            TaskItem(task,navigateToAddTaskScreen,updateTaskState, modifier = Modifier.padding(8.dp))
        }
    }

}

@Preview
@Composable
fun TasksListPreview() {
    TasksList(
        listOf(
            Task(
                1, true, "test", "20/03/2025"
            ), Task(
                2, false, "test", "20/03/2025"
            )
        ),{_ ->}, { _, _ -> }
    )

}