package com.example.sugtav.data.remote.api

import com.example.sugtav.data.remote.dto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DataGovApi {
    @GET("api/3/action/datastore_search")
    suspend fun searchVehicle(
        @Query("resource_id") resourceId: String,
        @Query("q") query: String,
    ): ApiResponse
}