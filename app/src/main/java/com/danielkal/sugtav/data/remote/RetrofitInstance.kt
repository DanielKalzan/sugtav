package com.danielkal.sugtav.data.remote

import com.danielkal.sugtav.data.remote.api.DataGovApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASEURL = "https://data.gov.il/"

    val api: DataGovApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataGovApi::class.java)
    }
}