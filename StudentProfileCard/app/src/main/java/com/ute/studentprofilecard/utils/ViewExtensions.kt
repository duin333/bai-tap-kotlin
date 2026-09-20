package com.ute.studentprofilecard.utils

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuất sắc!!"
    this >= 3.2 -> "Giỏi"
    this >= 2.5 -> "Khá"
    else -> "Trung bình"
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// Bổ sung Extension Function trimmedText cho EditText theo yêu cầu Slide
val EditText.trimmedText: String
    get() = this.text.toString().trim()

fun Context.showConfirmDialog(
    title: String = "Xác nhận",
    message: String,
    onConfirm: () -> Unit
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("Xóa") { dialog, _ ->
            onConfirm()
            dialog.dismiss()
        }
        .setNegativeButton("Hủy") { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}