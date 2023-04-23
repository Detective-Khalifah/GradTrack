package com.blogspot.thengnet.data

import java.time.LocalDate

data class Student(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val registrationNumber: String,
    val gender: String,
    val dateOfBirth: LocalDate?,
    val phoneNumber: String?,
    val address: String?,
    val nationality: String,
    val countryOfResidence: String?,
    val stateOfResidence: String?,
    val localGovernmentOfResidence: String?,
    val nextOfKinName: String?,
    val nextOfKinPhoneNumber: String?,
    val nextOfKinRelationship: String?
)
