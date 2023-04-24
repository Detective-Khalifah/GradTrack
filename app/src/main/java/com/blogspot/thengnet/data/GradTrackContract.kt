package com.blogspot.thengnet.data

import android.provider.BaseColumns

object GradTrackContract {
    // Role table
    object RoleEntry : BaseColumns {
        const val TABLE_NAME = "roles"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_NAME = "name"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    // User table
    object UserEntry : BaseColumns {
        const val TABLE_NAME = "users"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_FIRST_NAME = "first_name"
        const val COLUMN_MIDDLE_NAME = "middle_name"
        const val COLUMN_LAST_NAME = "last_name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_PHONE_NUMBER = "phone_number"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_ROLE_ID = "role_id"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_DATE_OF_BIRTH = "date_of_birth"
        const val COLUMN_NATIONALITY = "nationality"
        const val COLUMN_STATE_OF_ORIGIN = "state_of_origin"
        const val COLUMN_LOCAL_GOVERNMENT_OF_ORIGIN = "local_government_of_origin"
        const val COLUMN_COUNTRY_OF_RESIDENCE = "country_of_residence"
        const val COLUMN_STATE_OF_RESIDENCE = "state_of_residence"
        const val COLUMN_LOCAL_GOVERNMENT_OF_RESIDENCE = "local_government_of_residence"
        const val COLUMN_NEXT_OF_KIN_NAME = "next_of_kin_name"
        const val COLUMN_NEXT_OF_KIN_PHONE_NUMBER = "next_of_kin_phone_number"
        const val COLUMN_NEXT_OF_KIN_EMAIL = "next_of_kin_email"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    // Institution table
    object InstitutionEntry : BaseColumns {
        const val TABLE_NAME = "institutions"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_NAME = "name"
        const val COLUMN_ABBREVIATION = "abbreviation"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    // Faculty table
    object FacultyEntry : BaseColumns {
        const val TABLE_NAME = "faculties"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_INSTITUTION_ID = "institution_id"
        const val COLUMN_NAME = "name"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    // Department table
    object DepartmentEntry : BaseColumns {
        const val TABLE_NAME = "departments"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_NAME = "name"
        const val COLUMN_INSTITUTION_ID = "institution_id"
        const val COLUMN_FACULTY_ID = "faculty_id"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    // Course table
    object CourseEntry : BaseColumns {
        const val TABLE_NAME = "courses"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_CODE = "code"
        const val COLUMN_TITLE = "title"
        const val COLUMN_RANK = "rank"
        const val COLUMN_SEMESTER = "semester"
        const val COLUMN_CREDIT_UNIT = "credit_unit"
        const val COLUMN_MINIMUM_LEVEL = "minimum_level"
        const val COLUMN_FACULTY_ID = "faculty_id"
        const val COLUMN_DEPARTMENT_ID = "department_id"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    // Student table
    object StudentEntry {
        const val TABLE_NAME = "students"
        const val COLUMN_ID = "_id"
        const val COLUMN_REGISTRATION_NUMBER = "registration_number"
        const val COLUMN_INSTITUTION_ID = "institution_id"
        const val COLUMN_FACULTY_ID = "faculty_id"
        const val COLUMN_DEPARTMENT_ID = "department_id"
        const val COLUMN_CURRENT_LEVEL = "department_id"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }

    object GradeEntry {
        const val TABLE_NAME = "grades"
        const val COLUMN_ID = "_id"
        const val COLUMN_STUDENT_ID = "student_id"
        const val COLUMN_COURSE_ID = "course_id"
        const val COLUMN_SCORE = "score"
        const val COLUMN_GRADE = "grade"
        const val COLUMN_COURSE_SEMESTER = "semester"
        const val COLUMN_CREATED_BY = "created_by"
        const val COLUMN_UPDATED_BY = "updated_by"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_UPDATED_AT = "updated_at"
    }
}