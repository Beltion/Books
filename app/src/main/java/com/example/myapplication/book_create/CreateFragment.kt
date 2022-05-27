package com.example.myapplication.book_create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.myapplication.MainActivity
import com.example.myapplication.MainViewModel
import com.example.myapplication.book_edit_list.BookEditListFragment
import com.example.myapplication.book_list.BookListFragment
import com.example.myapplication.databinding.BookCreateBinding

class CreateFragment : Fragment(){

    private var _binding: BookCreateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreateViewModel by viewModels()
    private val aViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.book = aViewModel.bufferBook
        viewModel.bookId = aViewModel.buffBookId
        viewModel.authors = aViewModel.authors
        viewModel.publishers = aViewModel.publishers
        viewModel.initData()
        _binding = BookCreateBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel

        _binding?.viewModel?.bookMsg?.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }
        _binding?.viewModel?.toBookList?.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).changeFragment(BookListFragment())
        }

        return binding.root
    }



}