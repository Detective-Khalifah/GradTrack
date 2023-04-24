package com.blogspot.thengnet.data

import android.content.ContentValues
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
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.RoleEntry.TABLE_NAME} (
                ${GradTrackContract.RoleEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.RoleEntry.COLUMN_NAME} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.RoleEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.RoleEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.RoleEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.RoleEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
        """

        // SQL statement to create the users table
        private const val SQLITE_CREATE_USERS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.UserEntry.TABLE_NAME} (
                ${GradTrackContract.UserEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.UserEntry.COLUMN_FIRST_NAME} TEXT NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_MIDDLE_NAME} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_LAST_NAME} TEXT NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_USERNAME} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.UserEntry.COLUMN_GENDER} TEXT NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_DATE_OF_BIRTH} DATETIME NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_EMAIL} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.UserEntry.COLUMN_PASSWORD} TEXT NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_NATIONALITY} TEXT NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_STATE_OF_ORIGIN} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_LOCAL_GOVERNMENT_OF_ORIGIN} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_COUNTRY_OF_RESIDENCE} TEXT NOT NULL,
                ${GradTrackContract.UserEntry.COLUMN_STATE_OF_RESIDENCE} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_LOCAL_GOVERNMENT_OF_RESIDENCE} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_NEXT_OF_KIN_NAME} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_NEXT_OF_KIN_PHONE_NUMBER} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_NEXT_OF_KIN_EMAIL} TEXT,
                ${GradTrackContract.UserEntry.COLUMN_PHONE_NUMBER} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.UserEntry.COLUMN_ROLE_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.RoleEntry.TABLE_NAME}(${GradTrackContract.RoleEntry.COLUMN_ID}),
                ${GradTrackContract.UserEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.UserEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.UserEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.UserEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
        """

        // SQL statement to create the institutions table
        private const val SQLITE_CREATE_INSTITUTIONS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.InstitutionEntry.TABLE_NAME} (
                ${GradTrackContract.InstitutionEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.InstitutionEntry.COLUMN_NAME} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.InstitutionEntry.COLUMN_ABBREVIATION} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.InstitutionEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.InstitutionEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.InstitutionEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.InstitutionEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
            """

        // SQL statement to create the faculties table
        private const val SQLITE_CREATE_FACULTIES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.FacultyEntry.TABLE_NAME} (
                ${GradTrackContract.FacultyEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.FacultyEntry.COLUMN_NAME} TEXT NOT NULL,
                ${GradTrackContract.FacultyEntry.COLUMN_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.InstitutionEntry.TABLE_NAME}(${GradTrackContract.InstitutionEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.FacultyEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.FacultyEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.FacultyEntry.TABLE_NAME}(${GradTrackContract.FacultyEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.FacultyEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.FacultyEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.FacultyEntry.TABLE_NAME}(${GradTrackContract.FacultyEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE
            );
        """

        // SQL statement to create the departments table
        private const val SQLITE_CREATE_DEPARTMENTS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.DepartmentEntry.TABLE_NAME} (
                ${GradTrackContract.DepartmentEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.DepartmentEntry.COLUMN_NAME} TEXT NOT NULL,
                ${GradTrackContract.DepartmentEntry.COLUMN_FACULTY_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.FacultyEntry.TABLE_NAME}(${GradTrackContract.FacultyEntry.COLUMN_ID}) ON DELETE CASCADE ON UPDATE CASCADE,
                ${GradTrackContract.InstitutionEntry.COLUMN_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.InstitutionEntry.TABLE_NAME}(${GradTrackContract.InstitutionEntry.COLUMN_ID}) ON DELETE CASCADE ON UPDATE CASCADE,
                ${GradTrackContract.DepartmentEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.DepartmentEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.DepartmentEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.DepartmentEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE)
            ;
        """

        // SQL statement to create the courses table
        private const val SQLITE_CREATE_COURSES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.CourseEntry.TABLE_NAME} (
                ${GradTrackContract.CourseEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.CourseEntry.COLUMN_TITLE} TEXT NOT NULL,
                ${GradTrackContract.CourseEntry.COLUMN_CODE} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.CourseEntry.COLUMN_CREDIT_UNIT} INTEGER NOT NULL,
                ${GradTrackContract.CourseEntry.COLUMN_RANK} INTEGER NOT NULL,
                ${GradTrackContract.CourseEntry.COLUMN_MINIMUM_LEVEL} INTEGER NOT NULL,
                ${GradTrackContract.CourseEntry.COLUMN_SEMESTER} INTEGER NOT NULL,
                ${GradTrackContract.CourseEntry.COLUMN_FACULTY_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.FacultyEntry.TABLE_NAME}(${GradTrackContract.FacultyEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.CourseEntry.COLUMN_DEPARTMENT_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.DepartmentEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.CourseEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.CourseEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.CourseEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.CourseEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE, 
                CHECK (${GradTrackContract.CourseEntry.COLUMN_MINIMUM_LEVEL} >= 100 AND ${GradTrackContract.CourseEntry.COLUMN_MINIMUM_LEVEL} <= 900),
                UNIQUE (${GradTrackContract.CourseEntry.COLUMN_TITLE}, ${GradTrackContract.CourseEntry.COLUMN_DEPARTMENT_ID})
            );
        """

        // SQL statement to create the students table
        private const val SQLITE_CREATE_STUDENTS_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.StudentEntry.TABLE_NAME} (
                ${GradTrackContract.StudentEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.StudentEntry.COLUMN_REGISTRATION_NUMBER} TEXT NOT NULL UNIQUE,
                ${GradTrackContract.StudentEntry.COLUMN_INSTITUTION_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.InstitutionEntry.TABLE_NAME}(${GradTrackContract.InstitutionEntry.COLUMN_ID}) ON UPDATE CASCADE,
                ${GradTrackContract.StudentEntry.COLUMN_FACULTY_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.FacultyEntry.TABLE_NAME}(${GradTrackContract.FacultyEntry.COLUMN_ID}) ON UPDATE CASCADE,
                ${GradTrackContract.StudentEntry.COLUMN_DEPARTMENT_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.DepartmentEntry.TABLE_NAME}(${GradTrackContract.DepartmentEntry.COLUMN_ID}) ON UPDATE CASCADE,
                ${GradTrackContract.StudentEntry.COLUMN_CURRENT_LEVEL} INTEGER NOT NULL,
                ${GradTrackContract.StudentEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.StudentEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.StudentEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.StudentEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                UNIQUE (${GradTrackContract.StudentEntry.COLUMN_REGISTRATION_NUMBER}, ${GradTrackContract.StudentEntry.COLUMN_DEPARTMENT_ID})
            );
        """

        // SQL statement to create the grades table
        private const val SQLITE_CREATE_GRADES_TABLE = """
            CREATE TABLE IF NOT EXISTS ${GradTrackContract.GradeEntry.TABLE_NAME} (
                ${GradTrackContract.GradeEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${GradTrackContract.GradeEntry.COLUMN_COURSE_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.CourseEntry.TABLE_NAME}(${GradTrackContract.CourseEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.GradeEntry.COLUMN_STUDENT_ID} INTEGER NOT NULL REFERENCES ${GradTrackContract.StudentEntry.TABLE_NAME}(${GradTrackContract.StudentEntry.COLUMN_ID}),
                ${GradTrackContract.GradeEntry.COLUMN_GRADE} TEXT NOT NULL,
                ${GradTrackContract.GradeEntry.COLUMN_SCORE} INTEGER NOT NULL,
                ${GradTrackContract.GradeEntry.COLUMN_COURSE_SEMESTER} INTEGER NOT NULL,
                ${GradTrackContract.GradeEntry.COLUMN_CREATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.GradeEntry.COLUMN_CREATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                ${GradTrackContract.GradeEntry.COLUMN_UPDATED_AT} DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                ${GradTrackContract.GradeEntry.COLUMN_UPDATED_BY} INTEGER NOT NULL REFERENCES ${GradTrackContract.UserEntry.TABLE_NAME}(${GradTrackContract.UserEntry.COLUMN_ID}) ON DELETE RESTRICT ON UPDATE CASCADE,
                UNIQUE (${GradTrackContract.GradeEntry.COLUMN_COURSE_ID}, ${GradTrackContract.GradeEntry.COLUMN_STUDENT_ID}, ${GradTrackContract.GradeEntry.COLUMN_COURSE_SEMESTER})
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

    /**
     * This method adds a new student to the students table.
     * This method takes a Student object as a parameter, creates a new ContentValues object to
     * store the values for each column, inserts the new row into the students table using the
     * insert method of the SQLiteDatabase class, and returns the id of the newly inserted row.
     */
    fun addStudent(student: Student): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(
                GradTrackContract.StudentEntry.COLUMN_REGISTRATION_NUMBER,
                student.registrationNumber
            )
            put(GradTrackContract.StudentEntry.COLUMN_INSTITUTION_ID, student.institutionId)
            put(GradTrackContract.StudentEntry.COLUMN_FACULTY_ID, student.facultyId)
            put(GradTrackContract.StudentEntry.COLUMN_DEPARTMENT_ID, student.departmentId)
            put(GradTrackContract.StudentEntry.COLUMN_CREATED_BY, student.createdBy)
            put(GradTrackContract.StudentEntry.COLUMN_UPDATED_BY, student.updatedBy)
        }
        val newRowId = db.insert(GradTrackContract.StudentEntry.TABLE_NAME, null, values)
        db.close()
        return newRowId
    }

    /**
     * This method retrieves a student from the students table based on their id.
     * This method takes an integer id as input and returns a Student object. It first gets a
     * readable database object and constructs a SQL query to retrieve a student from the students
     * table based on their id. It then executes the query and retrieves the student data from the
     * resulting cursor. If a row is returned, it constructs a Student object with the retrieved
     * data and returns it. If no rows are returned, it returns null.
     */
    fun getStudentById(id: Int): Student? {
        val db = this.readableDatabase
        val projection = arrayOf(
            GradTrackContract.StudentEntry.COLUMN_ID,
            GradTrackContract.StudentEntry.COLUMN_REGISTRATION_NUMBER,
            GradTrackContract.StudentEntry.COLUMN_INSTITUTION_ID,
            GradTrackContract.StudentEntry.COLUMN_FACULTY_ID,
            GradTrackContract.StudentEntry.COLUMN_DEPARTMENT_ID,
            GradTrackContract.StudentEntry.COLUMN_CURRENT_LEVEL
        )
        val selection = "${GradTrackContract.StudentEntry.COLUMN_ID} = ?"
        val selectionArgs = arrayOf(id.toString())
        val cursor = db.query(
            GradTrackContract.StudentEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        var student: Student? = null
        with(cursor) {
            if (moveToNext()) {
                val userId = getInt(getColumnIndexOrThrow(GradTrackContract.StudentEntry.COLUMN_ID))
                val registrationNumber =
                    getString(getColumnIndexOrThrow(GradTrackContract.StudentEntry.COLUMN_REGISTRATION_NUMBER))
                val institutionId =
                    getInt(getColumnIndexOrThrow(GradTrackContract.StudentEntry.COLUMN_INSTITUTION_ID))
                val facultyId =
                    getInt(getColumnIndexOrThrow(GradTrackContract.StudentEntry.COLUMN_FACULTY_ID))
                val departmentId =
                    getInt(getColumnIndexOrThrow(GradTrackContract.StudentEntry.COLUMN_DEPARTMENT_ID))
                val currentLevel =
                    getInt(getColumnIndexOrThrow(GradTrackContract.StudentEntry.COLUMN_CURRENT_LEVEL))
                student = Student(
                    institutionId = institutionId,
                    facultyId = facultyId,
                    currentLevel = currentLevel,
                    registrationNumber = registrationNumber,
                    id = userId,
                    departmentId = departmentId
                )
            }
        }
        cursor.close()
        return student
    }

    /**
     * This method retrieves all students from the students table.
     * This method retrieves all the necessary fields from the students table, as well as the fields
     * that were moved to the users table using a JOIN statement. We then loop through the result
     * set and create a Student object for each row, which we add to a list of students. Finally,
     * we return the list of students.
     */
    fun getAllStudents(): List<Student> {
        val students = mutableListOf<Student>()
        val db = writableDatabase
        val query =
            "SELECT s._id, s.registration_number, u.first_name, u.last_name, u.middle_name," +
                    "u.gender, u.date_of_birth, u.nationality, u.country_of_residence," +
                    "u.state_of_residence, u.local_government_of_residence, u.state_of_origin," +
                    "u.local_government_of_origin, u.next_of_kin_name, u.next_of_kin_phone_number," +
                    "s.department_id, s.faculty_id, s.current_level " +
                    "FROM ${GradTrackContract.StudentEntry.TABLE_NAME} s " +
                    "JOIN ${GradTrackContract.UserEntry.TABLE_NAME} u ON s.user_id = u.id"
        val cursor = db.rawQuery(query, null)
        while (cursor.moveToNext()) {
            val student = Student(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("_id")),
                registrationNumber = cursor.getString(cursor.getColumnIndexOrThrow("registration_number")),
                firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name")),
                middleName = cursor.getString(cursor.getColumnIndexOrThrow("middle_name")),
                lastName = cursor.getString(cursor.getColumnIndexOrThrow("last_name")),
                gender = Gender.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("gender"))),
//                dateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow("date_of_birth")).toLocalDate(),
                nationality = cursor.getString(cursor.getColumnIndexOrThrow("nationality")),
                stateOfOrigin = cursor.getString(cursor.getColumnIndexOrThrow("state_of_origin")),
                localGovernmentOfOrigin = cursor.getString(cursor.getColumnIndexOrThrow("local_government_of_origin")),
                countryOfResidence = cursor.getString(cursor.getColumnIndexOrThrow("country_of_residence")),
                stateOfResidence = cursor.getString(cursor.getColumnIndexOrThrow("state_of_residence")),
                localGovernmentOfResidence = cursor.getString(cursor.getColumnIndexOrThrow("local_government_of_residence")),
                nextOfKinName = cursor.getString(cursor.getColumnIndexOrThrow("next_of_kin_name")),
                nextOfKinPhoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("next_of_kin_phone_number")),
                departmentId = cursor.getInt(cursor.getColumnIndexOrThrow("department_id")),
                facultyId = cursor.getInt(cursor.getColumnIndexOrThrow("faculty_id")),
                currentLevel = cursor.getInt(cursor.getColumnIndexOrThrow("current_level"))
            )
            students.add(student)
        }
        cursor.close()
        return students
    }

    /**
     * This method retrieves a student from the students table based on their {@param registration_number}
     * by joining the students table with the users table and selecting the appropriate columns.
     * It then creates a Student object from the retrieved data and returns it.
     */
    fun getStudentByRegistrationNumber(registrationNumber: String): Student? {
        val db = this.readableDatabase
        var student: Student? = null
        val query =
            "SELECT s.id, s.registration_number, u.first_name, u.last_name, u.middle_name, u.gender, u.date_of_birth, u.nationality, u.country_of_residence, u.state_of_residence, u.local_government_of_residence, u.state_of_origin, u.local_government_of_origin, u.next_of_kin_name, u.next_of_kin_phone_number, s.department_id, s.faculty_id, s.current_level " +
                    "FROM students s " +
                    "JOIN users u ON s.user_id = u.id " +
                    "WHERE s.registration_number = ?"
        val cursor = db.rawQuery(query, arrayOf(registrationNumber))
        if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name"))
            val lastName = cursor.getString(cursor.getColumnIndexOrThrow("last_name"))
            val middleName = cursor.getString(cursor.getColumnIndexOrThrow("middle_name"))
            val gender = Gender.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("gender")))
            val dateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow("date_of_birth"))
            val nationality = cursor.getString(cursor.getColumnIndexOrThrow("nationality"))
            val countryOfResidence =
                cursor.getString(cursor.getColumnIndexOrThrow("country_of_residence"))
            val stateOfResidence =
                cursor.getString(cursor.getColumnIndexOrThrow("state_of_residence"))
            val localGovernmentOfResidence =
                cursor.getString(cursor.getColumnIndexOrThrow("local_government_of_residence"))
            val stateOfOrigin = cursor.getString(cursor.getColumnIndexOrThrow("state_of_origin"))
            val localGovernmentOfOrigin =
                cursor.getString(cursor.getColumnIndexOrThrow("local_government_of_origin"))
            val nextOfKinName = cursor.getString(cursor.getColumnIndexOrThrow("next_of_kin_name"))
            val nextOfKinPhoneNumber =
                cursor.getString(cursor.getColumnIndexOrThrow("next_of_kin_phone_number"))
            val departmentId = cursor.getInt(cursor.getColumnIndexOrThrow("department_id"))
            val facultyId = cursor.getInt(cursor.getColumnIndexOrThrow("faculty_id"))
            val currentLevel = cursor.getInt(cursor.getColumnIndexOrThrow("current_level"))
            student = Student(
                id = id,
                registrationNumber = registrationNumber,
                firstName = firstName,
                lastName = lastName,
                middleName = middleName,
                gender = gender,
//                dateOfBirth = LocalDate.parse(dateOfBirth),
                nationality = nationality,
                countryOfResidence = countryOfResidence,
                stateOfResidence = stateOfResidence,
                localGovernmentOfResidence = localGovernmentOfResidence,
                stateOfOrigin = stateOfOrigin,
                localGovernmentOfOrigin = localGovernmentOfOrigin,
                nextOfKinName = nextOfKinName,
                nextOfKinPhoneNumber = nextOfKinPhoneNumber,
                departmentId = departmentId,
                facultyId = facultyId,
                currentLevel = currentLevel
            )
        }
        cursor.close()
        db.close()
        return student
    }

    /**
     *This method updates a student in the students table.
     *
     */
    fun updateStudent(student: Student): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("registration_number", student.registrationNumber)
            put("department_id", student.departmentId)
            put("faculty_id", student.facultyId)
            put("current_level", student.currentLevel)
        }
        val selection = "id = ?"
        val selectionArgs = arrayOf(student.id.toString())
        val count = db.update("students", values, selection, selectionArgs)
        db.close()
        return count > 0
    }

    /**
     * This method deletes a student from the students table based on their id.
     * This method takes in the {@param id} of the student to delete, and then uses the
     * writableDatabase property to get a writable instance of the database. It then constructs the
     * selection and selectionArgs parameters for the delete() method based on the {@param id}, and
     * calls the method to delete the student from the students table. Finally, the method
     * @return a Boolean indicating whether any rows were deleted or not.
     */
    fun deleteStudent(studentId: Int): Boolean {
        val db = this.writableDatabase
        val selection = "${GradTrackContract.StudentEntry.COLUMN_ID} = ?"
        val selectionArgs = arrayOf(studentId.toString())

        val deletedRows =
            db.delete(GradTrackContract.StudentEntry.TABLE_NAME, selection, selectionArgs)

        return deletedRows > 0
    }

    /**
     * This method adds a new course to the courses table.
     * This method first gets a writable database instance using writableDatabase. Then, it creates
     * a ContentValues object and populates it with the values of the Course object passed as a
     * @param. Finally, it calls the insert method on the database object and passes in the table
     * name and the ContentValues object. The method returns the id of the newly inserted row.
     */
    fun addCourse(course: Course): Long {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(GradTrackContract.CourseEntry.COLUMN_CODE, course.courseCode)
            put(GradTrackContract.CourseEntry.COLUMN_TITLE, course.courseTitle)
            put(GradTrackContract.CourseEntry.COLUMN_CREDIT_UNIT, course.creditUnit)
        }

        return db.insert(GradTrackContract.CourseEntry.TABLE_NAME, null, values)
    }

    /**
     * This method retrieves a course from the courses table based on its id.
     * This method takes in an integer @param courseId which is used to retrieve the course with the
     * corresponding id from the courses table. It returns a Course object if a course is found,
     * otherwise it returns null.
     */
    fun getCourseById(courseId: Int): Course? {
        val db = writableDatabase
        var course: Course? = null
        val selectQuery = "SELECT * FROM ${GradTrackContract.CourseEntry.TABLE_NAME} WHERE " +
                "${GradTrackContract.CourseEntry.COLUMN_ID} = $courseId"
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            course = Course(
                cursor.getInt(cursor.getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_CODE)),
                cursor.getString(cursor.getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_TITLE)),
                cursor.getInt(cursor.getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_CREDIT_UNIT)),
                cursor.getInt(cursor.getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_DEPARTMENT_ID))
            )
        }
        cursor.close()
        db.close()
        return course
    }

    /**
     * This method retrieves all courses from the courses table.
     * This method retrieves all columns for all rows in the courses table and returns a list of
     * Course objects representing each row.
     */
    fun getAllCourses(): List<Course> {
        val courses = mutableListOf<Course>()
        val db = readableDatabase
        val projection = arrayOf(
            GradTrackContract.CourseEntry.COLUMN_ID,
            GradTrackContract.CourseEntry.COLUMN_CODE,
            GradTrackContract.CourseEntry.COLUMN_TITLE,
            GradTrackContract.CourseEntry.COLUMN_CREDIT_UNIT
        )
        val cursor = db.query(
            GradTrackContract.CourseEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_ID))
                val code =
                    getString(getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_CODE))
                val title =
                    getString(getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_TITLE))
                val units =
                    getInt(getColumnIndexOrThrow(GradTrackContract.CourseEntry.COLUMN_CREDIT_UNIT))

                val course =
                    Course(id = id, courseCode = code, courseTitle = title, creditUnit = units)
                courses.add(course)
            }
        }

        cursor.close()
        return courses
    }

    /**
     * This method updates a course in the courses table.
     * This method takes a Course object as input and updates the corresponding record in the
     * courses table using the update method of the SQLiteDatabase class. It returns a Boolean
     * indicating whether the update was successful or not.
     */
    fun updateCourse(course: Course): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(GradTrackContract.CourseEntry.COLUMN_TITLE, course.courseTitle)
            put(GradTrackContract.CourseEntry.COLUMN_CODE, course.courseCode)
            put(GradTrackContract.CourseEntry.COLUMN_CREDIT_UNIT, course.creditUnit)
            put(GradTrackContract.CourseEntry.COLUMN_SEMESTER, course.semester)
        }
        val selection = "${GradTrackContract.CourseEntry.COLUMN_ID} = ?"
        val selectionArgs = arrayOf(course.id.toString())

        val count = db.update(
            GradTrackContract.CourseEntry.TABLE_NAME,
            values,
            selection,
            selectionArgs
        )

        return count > 0
    }

    /**
     * This method deletes a course from the courses table based on its id.
     * This method takes in a courseId parameter of type Int and returns a Boolean indicating
     * whether the deletion was successful or not. It gets a writable instance of the database and
     * calls the delete method on it with the CourseEntry.TABLE_NAME constant (which represents the
     * name of the courses table), and a whereClause parameter which specifies that only the row
     * with the given courseId should be deleted. The whereArgs parameter is an array of strings
     * which specifies the values to be replaced in the whereClause. The method returns true if at
     * least one row was affected by the deletion, and false otherwise.
     */
    fun deleteCourse(courseId: Int): Boolean {
        val db = writableDatabase
        return db.delete(
            GradTrackContract.CourseEntry.TABLE_NAME,
            "${GradTrackContract.CourseEntry.COLUMN_ID}=?",
            arrayOf(courseId.toString())
        ) > 0
    }


}