package com.blogspot.thengnet.data

class GradTrackContract {

    companion object {

        // Table names
        const val TABLE_ROLES = "roles"
        const val TABLE_USERS = "users"
        const val TABLE_INSTITUTIONS = "institutions"
        const val TABLE_FACULTIES = "faculties"
        const val TABLE_DEPARTMENTS = "departments"
        const val TABLE_COURSES = "courses"
        const val TABLE_STUDENTS = "students"
        const val TABLE_GRADES = "grades"

        // Common column names
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_AT = "updated_at"
        const val COLUMN_UPDATED_BY = "updated_by"

        // Roles Table - column names
        const val COLUMN_ROLE = "role"

        // Users Table - column names
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_ROLE_ID = "role_id"

        // Institutions Table - column names
        const val COLUMN_ABBREVIATION = "abbreviation"

        // Faculties Table - column names
        const val COLUMN_INSTITUTION_ID = "institution_id"

        // Departments Table - column names
        const val COLUMN_FACULTY_ID = "faculty_id"

        // Courses Table - column names
        const val COLUMN_DEPARTMENT_ID = "department_id"
        const val COLUMN_COURSE_CODE = "course_code"
        const val COLUMN_COURSE_TITLE = "course_title"
        const val COLUMN_COURSE_CREDIT_UNITS = "course_credit_units"
        const val COLUMN_COURSE_MINIMUM_LEVEL = "course_minimum_level"
        const val COLUMN_COURSE_SEMESTER = "course_semester"

        // Students Table - column names

        // Grades Table - column names
        const val COLUMN_COURSE_ID = "course_id"
        const val COLUMN_GRADE = "grade"

    }
}