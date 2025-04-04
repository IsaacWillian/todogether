package com.isaaclabs.todogether.ui.features.addtask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.isaaclabs.todogether.data.model.Task
import com.isaaclabs.todogether.ui.designsystem.TodogetherTextField
import com.isaaclabs.todogether.ui.theme.DarkBlue80

@Composable
fun AddTaskScreenRoute(taskId: Int?, navHostController: NavHostController) {
    val addTaskViewModel: AddTaskViewModel = viewModel()
    val taskToEdit = if(taskId != null){
        addTaskViewModel.getTask(taskId)
    } else null
    AddTaskScreen(taskToEdit) { id,desc, due ->
        addTaskViewModel.saveNewTask(id,desc, due)
        navHostController.popBackStack()
    }

}


@Composable
fun AddTaskScreen(taskToEdit: Task?, saveTaskEvent: (Int?,String, String) -> Unit) {
    var descriptionState by remember { mutableStateOf(taskToEdit?.description ?: "") }
    var dueDateState by remember { mutableStateOf(taskToEdit?.dueDate ?: "") }

    Surface(
        color = Color.Black,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 64.dp, end = 16.dp, bottom = 64.dp)
        ) {
            TodogetherTextField(descriptionState, "Description") { descriptionState = it }
            Spacer(modifier = Modifier.height(16.dp))
            TodogetherTextField(dueDateState, "Due Date") { dueDateState = it }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    saveTaskEvent(taskToEdit?.id,descriptionState, dueDateState)

                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors().copy(containerColor = DarkBlue80)
            ) {
                Text("Save")
            }
        }
    }

}

@Preview
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen(Task(1,true,"teste","teste")){ i,des, due -> }

}