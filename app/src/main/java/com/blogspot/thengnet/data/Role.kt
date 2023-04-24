package com.blogspot.thengnet.data

import java.time.LocalDateTime

data class Role(
    val id: Int,
    val name: String,
    val createdAt: LocalDateTime,
    val createdBy: Int,
    val updatedAt: LocalDateTime,
    val updatedBy: Int
)
