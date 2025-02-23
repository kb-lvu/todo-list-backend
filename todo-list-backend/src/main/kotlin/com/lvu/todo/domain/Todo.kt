package com.lvu.todo.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Todo(
    @Id
    val id: Long,
    val title: String,
    val description: String,
    val completed: Boolean
)
