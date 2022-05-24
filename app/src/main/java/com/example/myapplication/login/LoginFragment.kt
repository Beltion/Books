package com.example.myapplication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.LoginBinding
import com.example.myapplication.start_screen.StartScreenFragment

class LoginFragment : Fragment() {

    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel

        binding.viewModel?.loginMsg?.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }

        binding.viewModel?.loginSuccessEvent?.observe(viewLifecycleOwner){
//            (requireActivity() as MainActivity).changeFragment(StartScreenFragment())
        }

        return binding.root
    }

}