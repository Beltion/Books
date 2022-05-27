package com.example.myapplication.book_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.book_create.CreateFragment
import com.example.myapplication.book_del.DelFragment
import com.example.myapplication.book_edit_list.BookEditListFragment
import com.example.myapplication.book_find.FindFragment
import com.example.myapplication.book_list.BookListFragment

class BookMenuFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var seeBnt: Button
    private lateinit var createBtn: Button
    private lateinit var editBtn: Button
    private lateinit var delBtn: Button
    private lateinit var findBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.book_menu, container, false)

        seeBnt = rootView.findViewById(R.id.see)
        createBtn = rootView.findViewById(R.id.create)
        editBtn = rootView.findViewById(R.id.edit)
        delBtn = rootView.findViewById(R.id.del)
        findBtn = rootView.findViewById(R.id.find)

        seeBnt.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(BookListFragment())
        }
        createBtn.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(CreateFragment())
        }
        editBtn.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(BookEditListFragment())
        }
        delBtn.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(DelFragment())
        }
        findBtn.setOnClickListener {
            (requireActivity() as MainActivity).changeFragment(FindFragment())
        }
        return rootView
    }
}