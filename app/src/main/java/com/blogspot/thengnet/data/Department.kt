package com.blogspot.thengnet.data

import java.time.LocalDateTime

data class Department(
    val id: Int,
    val name: String,
    val facultyId: Int,
    val institutionId: Int,
    val createdAt: LocalDateTime,
    val createdBy: Int,
    val updatedAt: LocalDateTime,
    val updatedBy: Int
)
