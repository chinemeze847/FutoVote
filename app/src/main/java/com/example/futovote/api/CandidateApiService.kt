package com.example.futovote.api

import com.example.futovote.model.Candidate
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//TO-DO
private const val BASE_URL =
    "http://localhost:8080/VOTEAPP/api/"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StudentApiService
{
    /**
     * Returns a [List] of [Students] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "students" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("candidates")
    suspend fun getStudents(): List<Candidate>
}

object CandidateApi {
    /**
     * A public Api object that exposes the lazy-initialized Retrofit service
     */
    val retrofitService : StudentApiService by lazy{
        retrofit.create(StudentApiService::class.java)
    }
}