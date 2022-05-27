package com.example.myapplication.book_edit_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entities.books.Book

class EditViewModel : ViewModel() {

    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    var book: Book? = null

}