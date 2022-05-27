package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.entities.books.Book

class MainViewModel : ViewModel() {
    var bufferBook: Book? = null
}