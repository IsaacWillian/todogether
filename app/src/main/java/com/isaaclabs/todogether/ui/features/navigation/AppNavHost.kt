package com.isaaclabs.todogether.ui.features.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.isaaclabs.todogether.ui.features.addtask.AddTaskScreenRoute
import com.isaaclabs.todogether.ui.features.tasklist.TaskListViewModel
import com.isaaclabs.todogether.ui.features.tasklist.TaskScreenRoute
import kotlinx.serialization.Serializable

private const val TASK_ID = "taskId"

@Serializable
object TasksScreenRoute


@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = TasksScreenRoute
    ) {
        composable<TasksScreenRoute> {
            val taskListViewModel: TaskListViewModel = viewModel()
            TaskScreenRoute(taskListViewModel,
                navigateToAddTaskScreen = { taskId -> navHostController.navigate("addTask/?taskId=$taskId")})
        }
        composable(
            route = "addTask/?taskId={$TASK_ID}",
            arguments = listOf(navArgument(TASK_ID){type = NavType.StringType; nullable = true})
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString(TASK_ID)?.toIntOrNull()
            AddTaskScreenRoute(taskId,navHostController)
        }

    }


}