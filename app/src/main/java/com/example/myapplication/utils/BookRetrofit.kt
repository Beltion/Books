package com.example.myapplication.utils

import com.example.myapplication.entities.books.Author
import com.example.myapplication.entities.books.Book
import com.example.myapplication.entities.books.EditBook
import com.example.myapplication.entities.books.Publisher
import com.example.myapplication.entities.user.LoginUser
import com.example.myapplication.entities.user.RegUser
import com.example.myapplication.entities.user.SrvAnswerUser
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface BookApi {

    @POST("login")
    suspend fun login(
        @Body user: LoginUser
    ): SrvAnswerUser

    @POST("registration")
    suspend fun registration(
        @Body user: RegUser
    ): SrvAnswerUser

    @GET("books")
    suspend fun fetchBooks(): List<Book>

    @POST("books")
    suspend fun createBook(
        @Body b: EditBook
    ): SrvAnswerUser

    @PUT("book/{id}")
    suspend fun editBook(
        @Path("id") id: Int,
        @Body b: EditBook
    ): SrvAnswerUser

    @DELETE("book/{id}")
    suspend fun delBook(
        @Path("id") id: Int
    ): SrvAnswerUser

    @GET("books/{text}")
    suspend fun findBooks(
        @Path("text") t: String
    ): List<Book>

    @GET("authors")
    suspend fun fetchAuthors(): List<Author>

    @GET("publishers")
    suspend fun fetchPublishers(): List<Publisher>
}

object RetrofitClient {

    private var retrofitBook: Retrofit? = null

    fun getBookRetrofit(baseUrl: String): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        if (retrofitBook == null) {
            retrofitBook = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        return retrofitBook!!
    }

}

object RetrofitServices {
    val book: BookApi
        get() = RetrofitClient.getBookRetrofit(BookConstants.BASE_URL)
            .create(BookApi::class.java)
}

