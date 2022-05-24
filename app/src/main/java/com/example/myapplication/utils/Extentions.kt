package com.example.myapplication.utils

fun String.isEmailValid(): Boolean {
    val email: String = this.trim()
    return if (email.isNotEmpty()) {
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    } else {
        false
    }
}