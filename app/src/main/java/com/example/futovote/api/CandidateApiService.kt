package com.example.futovote.api

import com.example.futovote.model.Candidate
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "http://10.0.2.2:9090/api/candidates"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CandidateApiService
{
    @GET("/")
    suspend fun getCandidates(): List<Candidate>
}

object CandidateApi {

    val retrofitService : CandidateApiService by lazy{
        retrofit.create(CandidateApiService::class.java)
    }
}