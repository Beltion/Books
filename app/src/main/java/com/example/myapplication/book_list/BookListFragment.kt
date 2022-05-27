package com.example.myapplication.book_list

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
import com.example.myapplication.book_edit_list.EditFragment
import com.example.myapplication.databinding.BookListBinding

class BookListFragment : Fragment() {

    private var _binding: BookListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookListViewModel by viewModels()
    private val aViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BookListBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel
        _binding?.adapter = BookListAdapter(listOf(), viewModel)
        _binding?.viewModel?.bookMsg?.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }
        _binding?.viewModel?.toBookCard?.observe(viewLifecycleOwner) {
            aViewModel.bufferBook = it
            (requireActivity() as MainActivity).changeFragment(EditFragment())
        }

        return binding.root
    }



}