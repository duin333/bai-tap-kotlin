package com.ute.studentprofilecard.model

data class Student(
    val id: String,
    val name: String,
    val className: String,
    var gpa: Double,
    val phone: String
)