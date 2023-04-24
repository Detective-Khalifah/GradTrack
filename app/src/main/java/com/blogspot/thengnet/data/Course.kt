package com.blogspot.thengnet.data

data class Course(
    val id: Int,
    val courseCode: String,
    val courseTitle: String,
    val creditUnit: Int,
    val departmentId: Int = -1,
    val semester: Int = -1
)
