package com.isaaclabs.todogether.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id:Int,
    val checked: Boolean,
    val description: String,
    val dueDate: String,
)
