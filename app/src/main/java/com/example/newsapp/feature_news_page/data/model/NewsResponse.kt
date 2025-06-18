package com.example.newsapp.feature_news_page.data.model

import NewsResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DNewsResponse(
    @Json(name = "status") val status: String,
    @Json(name = "totalResults") val totalResults: Int,
    @Json(name = "articles") val articles: List<DNewsItem>
)

fun DNewsResponse.toDomainModel(): NewsResponse {
    val newsItems = articles.map { article: DNewsItem -> article.toDomainModel()}
    return NewsResponse(status,totalResults, articles = newsItems)
}