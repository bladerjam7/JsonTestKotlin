package com.americanairlines.jsontestkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.americanairlines.jsontestkotlin.R
import com.americanairlines.jsontestkotlin.model.BookResponse
import com.americanairlines.jsontestkotlin.view.adapter.BookAdapter

class BookFragment : Fragment() {

    private val bookAdapter = BookAdapter(mutableListOf())
    private lateinit var recyclerView: RecyclerView

    fun updateList(list: List<BookResponse>){
        bookAdapter.updateBookList(list)
        bookAdapter.notifyDataSetChanged()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_book_list)
        recyclerView.adapter = bookAdapter
    }


}