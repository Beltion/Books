package com.example.myapplication.entities.books

data class Book(
    val hardcover: String = "",
    val title: String = "",
    val abstract: String = "",
    val countpage: String = "",
    val status: Boolean = false,
    val author: Author? = null,
    val code: String = "",
    val publisher: Publisher? = null,
    val yearpublish: String = "",
)


//{
//    "hardcover": "твердый",
//    "title": "Талисман",
//    "abstract": "Текст какой-то",
//    "countpage": 678,
//    "status": true,
//    "author": {
//    "lastname": "Кинг",
//    "firstname": "Стивен"
//},
//    "code": "923-5-21-139112-8",
//    "publisher": {
//    "namepublisher": "АСТ",
//    "address": "г.Москва, ул.Порошина, д.89",
//    "site": "https://ast.ru/"
//},
//    "yearpublish": 2010
//}
