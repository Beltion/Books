package com.example.myapplication.book_find

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.MainActivity
import com.example.myapplication.book_edit_list.BookEditListViewModel
import com.example.myapplication.book_list.BookListAdapter
import com.example.myapplication.book_menu.BookMenuFragment
import com.example.myapplication.databinding.BookEditListBinding
import com.example.myapplication.databinding.BookFindBinding

class FindFragment : Fragment() {

    private var _binding: BookFindBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FindViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BookFindBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel
        _binding?.adapter = BookListAdapter(listOf(), viewModel)
        _binding?.viewModel?.bookMsg?.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }
        _binding?.viewModel?.back?.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).changeFragment(BookMenuFragment())
        }

        return binding.root
    }



}