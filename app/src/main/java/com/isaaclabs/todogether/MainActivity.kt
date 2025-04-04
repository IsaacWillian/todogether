package com.isaaclabs.todogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.isaaclabs.todogether.ui.theme.TodogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodogetherTheme {
                com.isaaclabs.todogether.ui.features.navigation.AppNavHost()
            }
        }
    }
}
