package com.example.newsapp.feature_news_page.data.model

import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DNewsItem(
    @Json(name = "source") val source: DNewsSource,
    @Json(name = "author") val author: String?,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String?,
    @Json(name = "url") val url: String,
    @Json(name = "urlToImage") val urlToImage: String?,
    @Json(name = "publishedAt") val publishedAt: String,
    @Json(name = "content") val content: String?,
)

fun DNewsItem.toDomainModel(): NewsItem {
    val source = source.toDomainModel()
    return NewsItem(
        source = source,
        author = author ?: "",
        title = title,
        description = description ?: "",
        url = url,
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt,
        content = content ?: ""
    )
}