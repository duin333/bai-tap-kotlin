data class Student(
    val studentId: String,
    val fullName: String,
    val age: Int,
    val major: String,
    val gpa: Double
)

fun addSampleStudents(students: MutableList<Student>) {
    students.add(
        Student(
            "2415053122311",
            "Nguyen Thai Ky Duyen",
            20,
            "Cong nghe thong tin",
            8.7
        )
    )

    students.add(
        Student(
            "2415053122312",
            "Tran Minh Khang",
            21,
            "Cong nghe thong tin",
            7.4
        )
    )

    students.add(
        Student(
            "2415053122313",
            "Le Gia Bao",
            23,
            "Ky thuat phan mem",
            9.1
        )
    )

    students.add(
        Student(
            "2415053122314",
            "Pham Ngoc Han",
            19,
            "He thong thong tin",
            6.3
        )
    )

    students.add(
        Student(
            "2415053122315",
            "Vo Minh Quan",
            22,
            "Cong nghe thong tin",
            4.6
        )
    )
}

fun addStudent(students: MutableList<Student>) {
    println()
    println("========== ADD STUDENT ==========")
    print("Student ID: ")
    val studentId = readln()
    print("Full Name: ")
    val fullName = readln()
    print("Age: ")
    val age = readln().toInt()
    print("Major: ")
    val major = readln()
    print("GPA: ")
    val gpa = readln().toDouble()

    val student = Student(
        studentId,
        fullName,
        age,
        major,
        gpa
    )

    students.add(student)
    println("Student added successfully!")
}

fun displayAllStudents(students: List<Student>) {
    if (students.isEmpty()) {
        println("No students.")
        return
    }

    println()
    println("========== ALL STUDENTS ==========")

    for (student in students) {
        println("Student ID: ${student.studentId}")
        println("Full Name : ${student.fullName}")
        println("Age       : ${student.age}")
        println("Major     : ${student.major}")
        println("GPA       : ${student.gpa}")
        println("----------------------------------")
    }
}

fun searchStudent(students: List<Student>) {
    println()
    println("========== SEARCH STUDENT ==========")
    print("Enter Student ID: ")
    val studentId = readln()

    val student = students.find {
        it.studentId == studentId
    }

    if (student != null) {
        println()
        println("Student found!")
        println("Student ID: ${student.studentId}")
        println("Full Name : ${student.fullName}")
        println("Age       : ${student.age}")
        println("Major     : ${student.major}")
        println("GPA       : ${student.gpa}")
    } else {
        println("Student not found!")
    }
}

fun calculateAverageGPA(students: List<Student>) {
    if (students.isEmpty()) {
        println("No students.")
        return
    }

    var totalGPA = 0.0

    for (student in students) {
        totalGPA += student.gpa
    }

    val averageGPA = totalGPA / students.size
    println("Average GPA: %.2f".format(averageGPA))
}

fun findHighestGPA(students: List<Student>) {
    if (students.isEmpty()) {
        println("No students.")
        return
    }

    val student = students.maxByOrNull {
        it.gpa
    }

    println()
    println("========== HIGHEST GPA ==========")
    println("Student ID: ${student?.studentId}")
    println("Full Name : ${student?.fullName}")
    println("Age       : ${student?.age}")
    println("Major     : ${student?.major}")
    println("GPA       : ${student?.gpa}")
}

fun removeStudent(students: MutableList<Student>) {
    println()
    println("========== REMOVE STUDENT ==========")
    print("Enter Student ID to remove: ")
    val studentId = readln()

    val student = students.find {
        it.studentId == studentId
    }

    if (student != null) {
        students.remove(student)
        println("Student removed successfully!")
    } else {
        println("Student not found!")
    }
}

fun countGPAAtLeast8(students: List<Student>) {
    var count = 0

    for (student in students) {
        if (student.gpa >= 8.0) {
            count++
        }
    }

    println("Number of students with GPA >= 8.0: $count")
}

fun countGPALessThan5(students: List<Student>) {
    var count = 0

    for (student in students) {
        if (student.gpa < 5.0) {
            count++
        }
    }

    println("Number of students with GPA < 5.0: $count")
}

fun calculateAverageGPAByMajor(students: List<Student>) {
    print("Enter major: ")
    val major = readln()

    val majorStudents = students.filter {
        it.major.equals(major, ignoreCase = true)
    }

    if (majorStudents.isEmpty()) {
        println("No students found in this major.")
        return
    }

    var totalGPA = 0.0

    for (student in majorStudents) {
        totalGPA += student.gpa
    }

    val averageGPA = totalGPA / majorStudents.size
    println("Average GPA of $major: %.2f".format(averageGPA))
}

fun findOldestStudent(students: List<Student>) {
    if (students.isEmpty()) {
        println("No students.")
        return
    }

    val student = students.maxByOrNull {
        it.age
    }

    println()
    println("========== OLDEST STUDENT ==========")
    println("Student ID: ${student?.studentId}")
    println("Full Name : ${student?.fullName}")
    println("Age       : ${student?.age}")
    println("Major     : ${student?.major}")
    println("GPA       : ${student?.gpa}")
}

fun findStudentsByGPARange(students: List<Student>) {
    val result = students.filter {
        it.gpa in 7.0..8.5
    }

    println()
    println("========== GPA FROM 7.0 TO 8.5 ==========")

    if (result.isEmpty()) {
        println("No students found.")
        return
    }

    for (student in result) {
        println(
            "${student.studentId} - " +
                    "${student.fullName} - " +
                    "GPA: ${student.gpa}"
        )
    }
}

fun findStudentsByMajor(students: List<Student>) {
    print("Enter major: ")
    val major = readln()

    val result = students.filter {
        it.major.equals(major, ignoreCase = true)
    }

    println()
    println("========== STUDENTS BY MAJOR ==========")

    if (result.isEmpty()) {
        println("No students found.")
        return
    }

    for (student in result) {
        println(
            "${student.studentId} - " +
                    "${student.fullName} - " +
                    "Age: ${student.age} - " +
                    "GPA: ${student.gpa}"
        )
    }
}

fun findStudentsByName(students: List<Student>) {
    print("Enter part of name: ")
    val keyword = readln()

    val result = students.filter {
        it.fullName.contains(
            keyword,
            ignoreCase = true
        )
    }

    println()
    println("========== SEARCH BY NAME ==========")

    if (result.isEmpty()) {
        println("No students found.")
        return
    }

    for (student in result) {
        println(
            "${student.studentId} - " +
                    "${student.fullName} - " +
                    "Major: ${student.major} - " +
                    "GPA: ${student.gpa}"
        )
    }
}

fun sortByGPADescending(students: MutableList<Student>) {
    students.sortByDescending {
        it.gpa
    }

    println()
    println("========== SORT BY GPA DESCENDING ==========")

    for (student in students) {
        println(
            "${student.studentId} - " +
                    "${student.fullName} - " +
                    "GPA: ${student.gpa}"
        )
    }
}

fun displayTop3GPA(students: List<Student>) {
    if (students.isEmpty()) {
        println("No students.")
        return
    }

    val result = students
        .sortedByDescending {
            it.gpa
        }
        .take(3)

    println()
    println("========== TOP 3 STUDENTS ==========")

    for (student in result) {
        println(
            "${student.studentId} - " +
                    "${student.fullName} - " +
                    "GPA: ${student.gpa}"
        )
    }
}

fun sortByAge(students: MutableList<Student>) {
    students.sortBy {
        it.age
    }

    println()
    println("========== SORT BY AGE ==========")

    for (student in students) {
        println(
            "${student.studentId} - " +
                    "${student.fullName} - " +
                    "Age: ${student.age}"
        )
    }
}

fun sortByName(students: MutableList<Student>) {
    students.sortBy {
        it.fullName
    }

    println()
    println("========== SORT BY NAME ==========")

    for (student in students) {
        println(
            "${student.studentId} - " +
                    "${student.fullName}"
        )
    }
}

fun additionalMenu(students: MutableList<Student>) {
    while (true) {
        println()
        println("========== ADDITIONAL FUNCTIONS ==========")
        println("1. Count students with GPA >= 8.0")
        println("2. Count students with GPA < 5.0")
        println("3. Calculate average GPA by major")
        println("4. Find student with highest GPA")
        println("5. Find oldest student")
        println("6. Find students with GPA from 7.0 to 8.5")
        println("7. Find all students by major")
        println("8. Find students by part of name")
        println("9. Sort students by GPA descending")
        println("10. Display top 3 students by GPA")
        println("11. Sort students by age")
        println("12. Sort students by name")
        println("0. Back to main menu")
        println("==========================================")
        print("Choose: ")

        val choice = readln().toInt()

        when (choice) {
            1 -> countGPAAtLeast8(students)
            2 -> countGPALessThan5(students)
            3 -> calculateAverageGPAByMajor(students)
            4 -> findHighestGPA(students)
            5 -> findOldestStudent(students)
            6 -> findStudentsByGPARange(students)
            7 -> findStudentsByMajor(students)
            8 -> findStudentsByName(students)
            9 -> sortByGPADescending(students)
            10 -> displayTop3GPA(students)
            11 -> sortByAge(students)
            12 -> sortByName(students)
            0 -> return
            else -> println("Invalid choice!")
        }
    }
}

fun main() {
    val students = mutableListOf<Student>()

    addSampleStudents(students)

    while (true) {
        println()
        println("========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student")
        println("4. Calculate average GPA")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("0. Exit")
        println("========================================")
        print("Choose: ")

        val choice = readln().toInt()

        when (choice) {
            1 -> {
                addStudent(students)
            }

            2 -> {
                displayAllStudents(students)
            }

            3 -> {
                searchStudent(students)
            }

            4 -> {
                calculateAverageGPA(students)
            }

            5 -> {
                findHighestGPA(students)
            }

            6 -> {
                removeStudent(students)
            }

            0 -> {
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid choice!")
            }
        }

        println()
        print("Do you want to use additional functions? (Y/N): ")
        val answer = readln()

        if (answer.equals("Y", ignoreCase = true)) {
            additionalMenu(students)
        }
    }
}
