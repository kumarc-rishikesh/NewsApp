package com.example.newsapp.feature_news_page.domain.repository

import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.example.newsapp.feature_news_page.domain.util.Resource
import retrofit2.Response

interface NewsRepository {
    suspend fun getNewsItems(country:String, category:String): Resource<List<NewsItem>>
}