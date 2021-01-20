package com.americanairlines.jsontestkotlin.network

//import com.americanairlines.jsontestkotlin.util.Const.Companion.BOOK_PATH
import com.americanairlines.jsontestkotlin.model.BookResponse
import com.americanairlines.jsontestkotlin.util.Const.Companion.PATH
import retrofit2.Call
import retrofit2.http.GET

interface BookNetworkService {

    @GET(PATH)
    fun getBookResponse() : Call<List<BookResponse>>
}