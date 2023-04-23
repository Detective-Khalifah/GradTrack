package com.blogspot.thengnet.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GradTrackerDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "gradtrack.db"

        // SQL statement to create the roles table
        private const val SQLITE_CREATE_ROLES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_ROLES} (
                ${GradTrackContract.COLUMN_ROLE_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.COLUMN_NAME} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
        """

        // SQL statement to create the users table
        private const val SQLITE_CREATE_USERS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_USERS} (
                ${GradTrackContract.COLUMN_USER_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                middle_name TEXT,
                last_name TEXT NOT NULL,
                ${GradTrackContract.COLUMN_USERNAME} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_EMAIL} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_PASSWORD} TEXT NOT NULL,
                state_of_origin TEXT,
                local_government_of_origin TEXT,
                state_of_residence TEXT,
                local_government_of_residence TEXT,
                next_of_kin_name TEXT,
                next_of_kin_phone TEXT,
                next_of_kin_email TEXT,
                phone_number TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_ROLE_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_ROLES}(${GradTrackContract.COLUMN_ROLE_ID}),
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
        """

        // SQL statement to create the institutions table
        private const val SQLITE_CREATE_INSTITUTIONS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_INSTITUTIONS} (
                ${GradTrackContract.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.COLUMN_NAME} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_ABBREVIATION} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
            """

        // SQL statement to create the faculties table
        private const val SQLITE_CREATE_FACULTIES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_FACULTIES} (
                ${GradTrackContract.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.COLUMN_NAME} TEXT NOT NULL,
                ${GradTrackContract.COLUMN_INSTITUTION_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_INSTITUTIONS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
        """

        // SQL statement to create the departments table
        private const val SQLITE_CREATE_DEPARTMENTS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_DEPARTMENTS} (
                ${GradTrackContract.COLUMN_DEPARTMENT_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.COLUMN_NAME} TEXT NOT NULL,
                ${GradTrackContract.COLUMN_FACULTY_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_FACULTIES}(${GradTrackContract.COLUMN_ID}) ON DELETE CASCADE ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_INSTITUTION_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_INSTITUTIONS}(${GradTrackContract.COLUMN_ID}) ON DELETE CASCADE ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE)
            ;
        """

        // SQL statement to create the courses table
        private const val SQLITE_CREATE_COURSES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_COURSES} (
                ${GradTrackContract.COLUMN_COURSE_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.COLUMN_COURSE_TITLE} TEXT NOT NULL,
                ${GradTrackContract.COLUMN_COURSE_CODE} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_COURSE_CREDIT_UNITS} INTEGER NOT NULL,
                core_course INTEGER NOT NULL,
                ${GradTrackContract.COLUMN_COURSE_MINIMUM_LEVEL} INTEGER NOT NULL,
                ${GradTrackContract.COLUMN_COURSE_SEMESTER} INTEGER NOT NULL,
                ${GradTrackContract.COLUMN_FACULTY_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_FACULTIES}(${GradTrackContract.COLUMN_FACULTY_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_DEPARTMENT_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_DEPARTMENTS}(${GradTrackContract.COLUMN_DEPARTMENT_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE, 
                CHECK (minimum_level >= 100 AND minimum_level <= 900),
                UNIQUE (name, department_id)
            );
        """

        // SQL statement to create the students table
        private const val SQLITE_CREATE_STUDENTS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_STUDENTS} (
                ${GradTrackContract.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                middle_name TEXT,
                last_name TEXT NOT NULL,
                registration_number TEXT NOT NULL UNIQUE,
                ${GradTrackContract.COLUMN_INSTITUTION_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_INSTITUTIONS}(${GradTrackContract.COLUMN_INSTITUTION_ID}) ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_FACULTY_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_FACULTIES}(${GradTrackContract.COLUMN_FACULTY_ID}) ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_DEPARTMENT_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_DEPARTMENTS}(${GradTrackContract.COLUMN_DEPARTMENT_ID}) ON UPDATE CASCADE,
                current_level INTEGER NOT NULL,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                UNIQUE (matric_no, department_id)
            );
        """

        // SQL statement to create the grades table
        private const val SQLITE_CREATE_GRADES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.TABLE_GRADES} (
                ${GradTrackContract.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.COLUMN_COURSE_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_COURSES}(${GradTrackContract.COLUMN_COURSE_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_STUDENTS}(${GradTrackContract.COLUMN_ID}),
                ${GradTrackContract.COLUMN_GRADE} TEXT NOT NULL,
                score INTEGER NOT NULL,
                ${GradTrackContract.COLUMN_COURSE_SEMESTER} INTEGER NOT NULL,
                ${GradTrackContract.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.TABLE_USERS}(${GradTrackContract.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                UNIQUE (course_id, student_id, semester)
            );
            """

    }

    override fun onCreate(db: SQLiteDatabase) {
        // create roles table
        db.execSQL(SQLITE_CREATE_ROLES_TABLE)

        // create users table
        db.execSQL(SQLITE_CREATE_USERS_TABLE)

        // create institutions table
        db.execSQL(SQLITE_CREATE_INSTITUTIONS_TABLE)

        // create faculties table
        db.execSQL(SQLITE_CREATE_FACULTIES_TABLE)

        // create departments table
        db.execSQL(SQLITE_CREATE_DEPARTMENTS_TABLE)

        // create courses table
        db.execSQL(SQLITE_CREATE_COURSES_TABLE)

        // create students table
        db.execSQL(SQLITE_CREATE_STUDENTS_TABLE)

        // create grades table
        db.execSQL(SQLITE_CREATE_GRADES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}


}