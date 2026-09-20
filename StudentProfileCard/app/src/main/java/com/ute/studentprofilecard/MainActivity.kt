package com.ute.studentprofilecard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofilecard.databinding.ActivityMainBinding
import com.ute.studentprofilecard.model.Student
import com.ute.studentprofilecard.utils.showConfirmDialog
import com.ute.studentprofilecard.utils.toAcademicRanking
import com.ute.studentprofilecard.utils.toast
import com.ute.studentprofilecard.utils.trimmedText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentStudent = Student(
        id = "2415053122311",
        name = "Nguyễn Thái Kỳ Duyên",
        className = "24T3",
        gpa = 3.2,
        phone = "0798871725"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Phục hồi dữ liệu điểm GPA nếu màn hình vừa bị xoay
        if (savedInstanceState != null) {
            currentStudent = currentStudent.copy(
                gpa = savedInstanceState.getDouble("KEY_GPA", currentStudent.gpa),
                name = savedInstanceState.getString("KEY_NAME", currentStudent.name)
            )
        }

        bindStudentData(currentStudent)

        // Áp dụng Scope Functions (apply, also) cho Intent
        binding.btnCall.setOnClickListener {
            Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${currentStudent.phone}")
            }.also { startActivity(it) }
        }

        binding.btnUpdateGpa.setOnClickListener {
            // Dùng Extension Property trimmedText đã viết
            val inputStr = binding.edtNewGpa.trimmedText
            val newGpa = inputStr.toDoubleOrNull()

            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.edtNewGpa.error = "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"
                toast("Điểm GPA không hợp lệ!")
                return@setOnClickListener
            }

            currentStudent = currentStudent.copy(gpa = newGpa)
            bindStudentData(currentStudent)
            toast("Cập nhật điểm thành công!")
        }

        binding.btnDelete.setOnClickListener {
            showConfirmDialog(
                title = "Cảnh báo",
                message = "Bạn có chắc chắn muốn xóa hồ sơ của sinh viên này không?"
            ) {
                currentStudent = Student("", "", "", 0.0, "")
                bindStudentData(currentStudent)
                toast("Đã xóa hồ sơ thành công!")
            }
        }
    }

    // Lưu GPA lại trước khi Activity bị hủy do xoay màn hình
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("KEY_GPA", currentStudent.gpa)
        outState.putString("KEY_NAME", currentStudent.name)
    }

    private fun bindStudentData(student: Student) {
        with(binding) {
            tvName.text = student.name
            tvStudentId.text =
                "MSSV: ${student.id} • Lớp: ${student.className}"
            tvPhone.text = "SĐT: ${student.phone}"
            tvGpaBadge.text =
                "${student.gpa} GPA (${student.gpa.toAcademicRanking()})"
            edtNewGpa.setText(student.gpa.toString())
        }
    }
}