package com.example.myapplication.book_list

import com.example.myapplication.R
import com.example.myapplication.databinding.ItemListBookBinding
import com.example.myapplication.entities.books.Book
import com.example.myapplication.utils.BaseAdapter

class BookListAdapter(
    private val list: List<Book>,
    private val booksListener: BooksListener
) : BaseAdapter<ItemListBookBinding, Book>(list) {

    override val layoutId: Int = R.layout.item_list_book

    override fun bind(binding: ItemListBookBinding, item: Book) {
        binding.apply {
            book = item
            listener = booksListener
            executePendingBindings()
        }
    }
}

interface BooksListener {
    fun onBookClicked(b: Book)
}