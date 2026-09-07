fun main() {
    val name = "Nguyễn Thái Kỳ Duyên"
    val studentId = "2415053122311"

    val math = 7.5
    val programming = 8.0
    val database = 6.5

    val total = math + programming + database
    val average = total / 3
    val highest = maxOf(math, programming, database)
    val isPassed = average >= 5.0

    println("Sinh viên $name (MSSV: $studentId) có tổng điểm là: $total")
    println("Sinh viên $name (MSSV: $studentId) có điểm trung bình là: $average")
    println("Sinh viên $name (MSSV: $studentId) có điểm cao nhất là: $highest")
    println("Sinh viên $name (MSSV: $studentId) ${if (isPassed) "ĐẠT" else "KHÔNG ĐẠT"} yêu cầu (GPA >= 5.0)")
}
