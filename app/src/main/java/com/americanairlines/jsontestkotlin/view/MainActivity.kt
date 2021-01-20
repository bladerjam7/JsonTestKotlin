package com.americanairlines.jsontestkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.americanairlines.jsontestkotlin.R
import com.americanairlines.jsontestkotlin.model.BookResponse
import com.americanairlines.jsontestkotlin.view.adapter.BookAdapter
//import com.americanairlines.jsontestkotlin.util.Const.Companion.BOOK_PATH
import com.americanairlines.jsontestkotlin.viewmodel.BooksViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val fragment: BookFragment = BookFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_list, fragment)
                .commit()

        val booksViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(BooksViewModel::class.java)

        Log.d("TAG_X", "onCreate: Checking")

        booksViewModel.lookUpBooks().observe(this, Observer {
            Log.d("TAG", "onCreate: " + it)
            fragment.updateList(it)

        })

    }
}