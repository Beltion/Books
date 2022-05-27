package com.example.myapplication.book_del

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.book_list.BookListAdapter
import com.example.myapplication.book_list.BookListViewModel
import com.example.myapplication.databinding.BookDelBinding
import com.example.myapplication.databinding.BookListBinding

class DelFragment : Fragment() {

    private var _binding: BookDelBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DelBookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BookDelBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel
        _binding?.adapter = BookListAdapter(listOf(), viewModel)
        _binding?.viewModel?.bookMsg?.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }

        return binding.root
    }



}