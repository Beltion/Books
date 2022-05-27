package com.example.myapplication.book_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.books.Book
import com.example.myapplication.repositories.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel(), BooksListener {

    private val _bookList = MutableLiveData<List<Book>>()
    val bookList: LiveData<List<Book>> = _bookList

    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val toBookCard: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            fetchBooks().catch {
            }.collect {

                _bookList.value = it
            }
        }
    }

    private fun fetchBooks() = flow<List<Book>> {
        BookRepository().fetchBooks()?.let {
            emit(it)
        } ?: run {
            bookMsg.value = "Не удалось получить список книг"
        }
    }.flowOn(Dispatchers.IO)

    override fun onBookClicked(b: Book) {
        toBookCard.value = b
    }

}