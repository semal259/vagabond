package com.constraint.vagabond.main.search

import com.constraint.vagabond.data.entities.RecreationalAreaList
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface GetRecAreasData {

    @GET("recareas")
    fun getRecreationalAreaData(
            @Query("query") query: String,
            @Query("full") full: Boolean,
            @Header("apikey") apiKey: String): Observable<RecreationalAreaList>

    companion object Factory {

        private const val BASE_URL = "https://ridb.recreation.gov/api/v1/"

        fun create(): GetRecAreasData {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(GetRecAreasData::class.java)
        }
    }
}


