package com.example.newsapp.feature_news_page.data.repository

import android.util.Log
import com.example.newsapp.BuildConfig
import com.example.newsapp.feature_news_page.data.model.DNewsResponse
import com.example.newsapp.feature_news_page.data.model.toDomainModel
import com.example.newsapp.feature_news_page.data.network.NewsAPIService
import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.example.newsapp.feature_news_page.domain.repository.NewsRepository
import com.example.newsapp.feature_news_page.domain.util.Resource
import retrofit2.Response
import javax.inject.Inject

private const val API_KEY = BuildConfig.NEWS_API_KEY

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsAPIService
        ):NewsRepository {
     override suspend fun getNewsItems(country:String, category:String): Resource<List<NewsItem>> {
         try {
             val newsItems = newsApi.getNewsItems(country, category, API_KEY)
             if (newsItems.isSuccessful && newsItems.body() != null) {
                 val data: DNewsResponse = newsItems.body()!!
                 Log.d("checking impl success", newsItems.toString())
                 return Resource.success(data = data.toDomainModel().articles)
             } else {
                 Log.d("checking impl fail 1", newsItems.toString())
                 return Resource.error((newsItems.body() ?: "OOPS!!!").toString(), null)
             }
         } catch(e: Exception){
             Log.d("checking impl fail 2",e.toString())
             return Resource.error("OOPS!!!", null)
         }
    }
}