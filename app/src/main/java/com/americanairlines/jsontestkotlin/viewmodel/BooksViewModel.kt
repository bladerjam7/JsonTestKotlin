package com.americanairlines.jsontestkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.americanairlines.jsontestkotlin.model.BookResponse
import com.americanairlines.jsontestkotlin.network.BookRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class BooksViewModel : ViewModel() {

    private val executor: ExecutorService = Executors.newCachedThreadPool()

    /*fun lookUpBooks(bookQuery : String) : LiveData<List<BookResponse>>{
        BookRetrofit.getBookRetrofitInstance().getBookResults(bookQuery)
            .enqueue(object : Callback<List<BookResponse>>{
                override fun onFailure(call: Call<List<BookResponse>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<List<BookResponse>>,
                    response: Response<List<BookResponse>>
                ) {
                    if(response.isSuccessful() && response.body() != null)
                        bookResult.postValue(response.body())
                }
            })

        return bookResult
    }*/

    private var bookResult: MutableLiveData<List<BookResponse>> = MutableLiveData()

    fun lookUpBooks(): LiveData<List<BookResponse>> {
        Log.d("TAG_X", "lookUpBooks: In lookup")

        executor.execute{
            BookRetrofit.getBookResults().enqueue(object: Callback<List<BookResponse>>{
                override fun onFailure(call: Call<List<BookResponse>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }

                override fun onResponse(call: Call<List<BookResponse>>, response: Response<List<BookResponse>>) {
                    Log.d("TAG", "onResponse: Work please -> " + response.body())
                    bookResult.postValue(response.body())
                }

            })
        }



        Log.d("TAG_X", "lookUpBooks: Out lookup -> " + bookResult)
        return bookResult

    }
}




