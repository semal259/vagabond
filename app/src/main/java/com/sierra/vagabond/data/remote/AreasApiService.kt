package com.sierra.vagabond.data.remote

import com.sierra.vagabond.data.entities.RecreationalAreaList
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AreasApiService {

    @GET(AREAS_ENDPOINT)
    fun getRecreationalAreaData(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Query("activity") activity: String,
            @Header("apikey") apiKey: String): Single<RecreationalAreaList>


    companion object Factory {

        private const val AREAS_ENDPOINT = "recareas"
        private const val BASE_ENDPOINT = "https://ridb.recreation.gov/api/v1/"

        fun create(): AreasApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_ENDPOINT)
                    .build()
            return retrofit.create(AreasApiService::class.java)
        }
    }
}



