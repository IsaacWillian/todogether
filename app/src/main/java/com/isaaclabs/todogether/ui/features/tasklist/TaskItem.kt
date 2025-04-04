package com.isaaclabs.todogether.ui.features.tasklist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaaclabs.todogether.data.model.Task
import com.isaaclabs.todogether.ui.theme.DarkBlue80


@Composable
fun TaskItem(task: Task,navigateToAddTaskScreen: (String?) -> Unit, updateTaskState: (Boolean, Int) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(8.dp, 8.dp, 8.dp, 8.dp)
            .clickable { navigateToAddTaskScreen(task.id.toString()) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.checked, onCheckedChange = { updateTaskState(!task.checked,task.id)},
            colors = CheckboxDefaults.colors().copy(
                checkedBoxColor = DarkBlue80,
                checkedBorderColor = DarkBlue80,
                uncheckedBorderColor = DarkBlue80
            )
        )
        Column {
            Text(
                text = task.description,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = task.dueDate,
                color = Color.LightGray,
                style = MaterialTheme.typography.bodySmall
            )

        }


    }

}

@Preview
@Composable
fun NotePreview() {
    TaskItem(
        Task(
            1,
            false,
            "teste",
            "20/03/2025"
        ),
        {_ ->} ,{_,_ ->}
    )
}


