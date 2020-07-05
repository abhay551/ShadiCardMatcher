package com.abhay.shadicardmatcher.data.api

import com.abhay.shadicardmatcher.data.model.ShadiMatcherModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShadiCardMatcherApiService {

    @GET("api")
    suspend fun fetchRandomUsers(
        @Query("results") resultsCount: Int
    ): Response<ShadiMatcherModelResponse>

}