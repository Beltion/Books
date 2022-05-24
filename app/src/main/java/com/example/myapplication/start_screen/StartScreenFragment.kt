package com.example.myapplication.start_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.login.LoginFragment
import com.example.myapplication.reg.RegistrationFragment

class StartScreenFragment: Fragment() {

    private lateinit var rootView: View
    private lateinit var regBnt: Button
    private lateinit var loginBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.start_screen, container, false)

        loginBtn = rootView.findViewById(R.id.login)
        regBnt = rootView.findViewById(R.id.registration)

        loginBtn.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(LoginFragment())
        }
        regBnt.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(RegistrationFragment())
        }
        return rootView
    }
}