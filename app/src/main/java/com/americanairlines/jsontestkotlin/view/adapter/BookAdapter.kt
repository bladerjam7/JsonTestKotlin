package com.americanairlines.jsontestkotlin.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.americanairlines.jsontestkotlin.R
import com.americanairlines.jsontestkotlin.model.BookResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BookAdapter(private var bookList: List<BookResponse>) : RecyclerView.Adapter<BookAdapter.BookHolder>() {

    fun updateBookList(bookList: List<BookResponse>){
        this.bookList = bookList
    }

    class BookHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val tvTitle: TextView = itemview.findViewById(R.id.tv_title)
        val tvAuthor: TextView = itemview.findViewById(R.id.tv_author)
        val ivImageUrl: ImageView = itemview.findViewById(R.id.iv_book_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder =
            BookHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val bookItem = bookList[position]
        holder.apply {
            tvTitle.text = bookItem.title
            tvAuthor.text = bookItem.author

            Glide.with(itemView.context)
                    .applyDefaultRequestOptions(RequestOptions().centerCrop())
                    .load(bookItem.imageURL)
                    .into(ivImageUrl)
        }
    }
}