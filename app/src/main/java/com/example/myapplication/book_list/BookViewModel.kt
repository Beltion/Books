package com.example.myapplication.book_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entities.books.Book

class BookViewModel : ViewModel(){
    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    var book: Book? = null
    val yes = "Да"
    val no = "Нет"
}