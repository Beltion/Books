package com.example.myapplication.repositories

import com.example.myapplication.entities.books.Book
import com.example.myapplication.utils.RetrofitServices

class BookRepository {

    suspend fun fetchBooks(): List<Book>? {
        return try {
            RetrofitServices.book.fetchBooks()
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }
}