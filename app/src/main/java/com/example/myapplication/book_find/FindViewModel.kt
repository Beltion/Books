package com.example.myapplication.book_find

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.book_list.BooksListener
import com.example.myapplication.entities.books.Book
import com.example.myapplication.repositories.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FindViewModel : ViewModel(), BooksListener {

    private val _bookList = MutableLiveData<List<Book>>()
    val bookList: LiveData<List<Book>> = _bookList

    var findText: String = ""

    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val back: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun onFindClick() {
        viewModelScope.launch {
            fetchBooks().catch {
                bookMsg.value = "Не удалось получить список книг"
            }.collect {
                _bookList.value = it
            }
        }
    }

    fun fetchBooks() = flow<List<Book>> {
        if (findText.isNotEmpty()){
            BookRepository().findBooks(findText)?.let {
                emit(it)
            } ?: run {
                bookMsg.value = "Не удалось получить список книг"
            }
        } else {
            bookMsg.value = "Заполните данные"
        }

    }.flowOn(Dispatchers.IO)

    override fun onBookClicked(b: Book) {

    }

    fun onBack(){
        back.value = ""
    }

}