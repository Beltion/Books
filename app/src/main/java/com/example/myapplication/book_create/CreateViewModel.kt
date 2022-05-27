package com.example.myapplication.book_create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.books.Book
import com.example.myapplication.entities.books.EditBook
import com.example.myapplication.repositories.BookRepository
import kotlinx.coroutines.launch

class CreateViewModel  : ViewModel() {
    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val toBookList: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    lateinit var authors: List<String>
    lateinit var publishers: List<String>

    val hardcoverEntities = listOf("мягкий","твердый")

    var hardcoverPosition: Int = 0
    var authorsPosition: Int = 0
    var publisherPosition: Int = 0

    var hardcover: String = ""
    var title: String = ""
    var abstract: String = ""
    var countpage: String = ""
    var status: Boolean = false
    var code: String = ""
    var yearpublish: String = ""


    private fun findAuthorPosition(author: String) {
        authors.forEachIndexed { index, s ->
            if (s == author){
                authorsPosition = index
            }
        }
    }

    private fun findPublisherPosition(author: String) {
        publishers.forEachIndexed { index, s ->
            if (s == author){
                publisherPosition = index
            }
        }
    }

    fun onSave(){
        viewModelScope.launch {
            findAuthorPosition(authors[authorsPosition])
            findPublisherPosition(publishers[publisherPosition] )
                val b = EditBook(
                    hardcover = hardcoverEntities[hardcoverPosition],
                    title = title,
                    abstract = abstract,
                    countpage = countpage,
                    status = status,
                    authorid = authorsPosition,
                    code = code,
                    publishid = publisherPosition,
                    yearpublish = yearpublish
                )
                BookRepository().createBook(b)?.let {
                    bookMsg.value = "Книга успешно сохранена"
                    toBookList.value = 1
                } ?: kotlin.run {
                    bookMsg.value = "Не удалось сохранить книгу"
                }

        }
    }

    fun onCancel(){
        toBookList.value = 1
    }

}