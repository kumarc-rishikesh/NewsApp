package com.example.newsapp.feature_news_page.domain.use_case

import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.example.newsapp.feature_news_page.domain.repository.NewsRepository
import com.example.newsapp.feature_news_page.domain.util.Resource

class GetNewsItems (
    private val repository: NewsRepository
){
    suspend operator fun invoke(): Resource<List<NewsItem>> =
         repository.getNewsItems(category = "business", country = "us")
}