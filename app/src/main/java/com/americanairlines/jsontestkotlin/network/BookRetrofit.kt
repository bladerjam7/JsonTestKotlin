package com.americanairlines.jsontestkotlin.network

import android.util.Log
import com.americanairlines.jsontestkotlin.model.BookResponse
import com.americanairlines.jsontestkotlin.util.Const.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookRetrofit {
    private val bookNetworkService: BookNetworkService = createBookService(createRetrofit())

    private fun createBookService(retrofit: Retrofit): BookNetworkService {
        return retrofit.create(BookNetworkService::class.java)
    }

    private fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getBookResults() : Call<List<BookResponse>> {
       // return bookNetworkService.getBookResponse(s)
        Log.d("TAG_X", "getBookResults: In getBooks")
        return bookNetworkService.getBookResponse()
    }





}