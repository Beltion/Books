package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.myapplication.book_menu.BookMenuFragment
import com.example.myapplication.reg.RegistrationFragment
import com.example.myapplication.start_screen.StartScreenFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById(R.id.main_frame_layout)
        changeFragment(StartScreenFragment())
    }

    fun changeFragment(f: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer.id, f)
            .commitAllowingStateLoss()
    }


}