package com.example.myapplication.reg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.UserRegistrationBinding
import com.example.myapplication.start_screen.StartScreenFragment

class RegistrationFragment : Fragment() {

    private var _binding: UserRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserRegistrationBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.viewModel = viewModel

        binding.viewModel?.regMsg?.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                .show()
        }

        binding.viewModel?.regSuccessEvent?.observe(viewLifecycleOwner){
            (requireActivity() as MainActivity).changeFragment(StartScreenFragment())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
