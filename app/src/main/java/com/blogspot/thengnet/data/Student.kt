package com.blogspot.thengnet.data

import java.time.LocalDate
import java.time.LocalTime

data class Student(
    val id: Int = -1,
    val firstName: String = "N/A",
    val middleName: String? = "N/A",
    val lastName: String = "N/A",
    val email: String = "N/A",
    val registrationNumber: String = "N/A",
    val institutionId: Int = -1,
    val facultyId: Int = -1,
    val departmentId: Int = -1,
    val currentLevel: Int = -1,
    val gender: Gender? = null,
    val dateOfBirth: LocalDate? = null,
    val phoneNumber: String? = "N/A",
//    val address: String?,
    val nationality: String = "N/A",
    val stateOfOrigin: String? = "N/A",
    val localGovernmentOfOrigin: String? = "N/A",
    val countryOfResidence: String? = "N/A",
    val stateOfResidence: String? = "N/A",
    val localGovernmentOfResidence: String? = "N/A",
    val nextOfKinName: String? = "N/A",
    val nextOfKinPhoneNumber: String? = "N/A",
    val nextOfKinRelationship: String? = "N/A",
    val createdBy: Int = -1,
    val createdAt: LocalTime? = null,
    val updatedBy: Int = -1,
    val updatedAt: LocalTime? = null,
)
