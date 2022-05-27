package com.example.myapplication.repositories

import android.util.Log
import com.example.myapplication.entities.books.Author
import com.example.myapplication.entities.books.Book
import com.example.myapplication.entities.books.EditBook
import com.example.myapplication.entities.books.Publisher
import com.example.myapplication.entities.user.SrvAnswerUser
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

    suspend fun createBook(b: EditBook) : SrvAnswerUser? {
        return try {
            RetrofitServices.book.createBook(b)
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }

    suspend fun editBook(id: Int, b:EditBook) : SrvAnswerUser? {
        return try {
            Log.e("hhh", b.toString())
            RetrofitServices.book.editBook(id, b)
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }

    suspend fun delBook(id: Int): SrvAnswerUser? {
        return try {
            RetrofitServices.book.delBook(id)
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }

    suspend fun findBooks(t: String) : List<Book>? {
        return try {
            RetrofitServices.book.findBooks(t)
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }
    suspend fun fetchAuthors() : List<Author>? {
        return try {
            RetrofitServices.book.fetchAuthors()
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }
    suspend fun fetchPublishers() : List<Publisher>? {
        return try {
            RetrofitServices.book.fetchPublishers()
        } catch (t: Throwable){
            t.printStackTrace()
            null
        }
    }
}