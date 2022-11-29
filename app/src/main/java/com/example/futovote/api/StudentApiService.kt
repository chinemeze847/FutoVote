package com.example.futovote.api

import com.example.futovote.model.StudentRequestDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


private const val BASE_URL =
    "http://192.168.43.235:9090/api/students/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StudentApiService
{
    @POST("login")
    suspend fun login(@Body requestDto: StudentRequestDto): String
}

object StudentApi {
    val retrofitService : StudentApiService by lazy{
        retrofit.create(StudentApiService::class.java)
    }
}