package com.example.animerealm.util

import com.example.animerealm.model.MangaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanApi {
    @GET("manga")
    suspend fun getManga(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): MangaResponse
}