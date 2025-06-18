package com.example.newsapp.feature_news_page.data.network

import com.example.newsapp.BuildConfig
import com.example.newsapp.feature_news_page.data.model.DNewsResponse
import com.example.newsapp.feature_news_page.domain.model.NewsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("top-headlines")
    suspend fun getNewsItems(
        @Query("country") country:String,
        @Query("category") category :String,
        @Query("apikey") apiKey: String)
    : Response<DNewsResponse>
    }