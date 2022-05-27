package com.example.myapplication.book_edit_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.books.Book
import com.example.myapplication.entities.books.EditBook
import com.example.myapplication.repositories.BookRepository
import kotlinx.coroutines.launch

class EditViewModel : ViewModel() {
    val bookMsg: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val toBookEditList: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    var book: Book? = null
    var bookId: Int? = null
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


    fun initData() {
        book?.let {
            title = it.title
            hardcover = it.hardcover
            hardcoverPosition = if (hardcover == "твердый"){
                1
            } else {
                0
            }
            findAuthorPosition("${it.author?.firstname} ${it.author?.lastname}")
            findPublisherPosition(it.publisher?.namepublisher ?: "")
            abstract = it.abstract
            countpage = it.countpage
            status = it.status
            code = it.code
            yearpublish = it.yearpublish
        }
    }

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
            Log.e("hhh", "1")
            bookId?.let {
                val b = EditBook(
                    hardcover = hardcover,
                            title = title,
                            abstract = abstract,
                            countpage = countpage,
                            status = status,
                            authorid = authorsPosition,
                            code = code,
                            publishid = publisherPosition,
                            yearpublish = yearpublish
                )
                BookRepository().editBook(it, b)?.let {
                    bookMsg.value = "Данные успешно обновлены"
                    toBookEditList.value = 1
                } ?: kotlin.run {
                    bookMsg.value = "Не удалось обновить данные"
                }

                Log.e("hhh", "2")
            }

        }
    }

    fun onCancel(){
        toBookEditList.value = 1
    }

}