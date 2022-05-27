package com.example.myapplication.book_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.myapplication.MainViewModel
import com.example.myapplication.databinding.CardBookBinding
import com.example.myapplication.databinding.ItemListBookBinding

class BookFragment : Fragment(){

    private var _binding: CardBookBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookViewModel by viewModels()
    private val aViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.book = aViewModel.bufferBook
        _binding = CardBookBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel

        _binding?.viewModel?.bookMsg?.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }

        return binding.root
    }



}