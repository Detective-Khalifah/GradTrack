package com.blogspot.thengnet.data

import java.time.LocalDateTime

data class Faculty(
    val id: Int,
    val name: String,
    val abbreviation: String?,
    val institutionId: Int,
    val createdAt: LocalDateTime?,
    val createdBy: Int?,
    val updatedAt: LocalDateTime?,
    val updatedBy: Int?
)
