package com.example.verblearn.data.remote

import com.example.verblearn.data.remote.dto.VerbsDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VerbsAPI {
    @GET("api/Verbs")
    suspend fun getVerbs():List<VerbsDTO>

    @GET("api/Verbs/{id}")
    suspend fun getVerbsById(@Path("id") id: Int): VerbsDTO?

    @POST("api/Verbs")
    suspend fun postVerbs(@Body verb: VerbsDTO) : Response<VerbsDTO>
}