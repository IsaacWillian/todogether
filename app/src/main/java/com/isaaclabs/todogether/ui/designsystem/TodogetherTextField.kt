package com.isaaclabs.todogether.ui.designsystem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TodogetherTextField(text: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(text,onValueChange, label = { Text(label, color = Color.White) }, textStyle = TextStyle(color = Color.White, fontWeight = FontWeight(800)), modifier = Modifier.fillMaxWidth() )

}