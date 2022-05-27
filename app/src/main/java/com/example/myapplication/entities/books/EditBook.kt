package com.example.myapplication.entities.books

data class EditBook(
    val hardcover: String,
    val title: String,
    val abstract: String,
    val countpage: String,
    val status: Boolean,
    val authorid: Int,
    val code: String,
    val publishid: Int,
    val yearpublish: String
)
