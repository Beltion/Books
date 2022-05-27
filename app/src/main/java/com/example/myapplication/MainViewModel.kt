package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.books.Author
import com.example.myapplication.entities.books.Book
import com.example.myapplication.entities.books.Publisher
import com.example.myapplication.repositories.BookRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var bufferBook: Book? = null
    var buffBookId: Int? = null

    val authors = mutableListOf<String>()
    val publishers = mutableListOf<String>()

    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    init {
        getAuthors()
        getPublishers()
    }

    private fun getAuthors() {
        viewModelScope.launch {
            BookRepository().fetchAuthors()?.let {
                it.forEach { a ->
                    authors.add("${a.firstname} ${a.lastname}")
                    Log.e("HHH", "getPublishers ;${a.firstname}")
                }
            } ?: run {
                bookMsg.value = "Не удалось загрузить авторов"
            }
        }
    }

    private fun getPublishers() {
        viewModelScope.launch {
            BookRepository().fetchPublishers()?.let {
                it.forEach { p ->
                    publishers.add(p.namepublisher)
                    Log.e("HHH", "getPublishers ;${p.namepublisher}")
                }
             }?: run {
                bookMsg.value = "Не удалось загрузить издателей"
            }
        }
    }
}