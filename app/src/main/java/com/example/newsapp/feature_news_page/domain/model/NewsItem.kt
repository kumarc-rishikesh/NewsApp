package com.example.newsapp.feature_news_page.domain.model

data class NewsItem(
    val source: NewsSource,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
){
    companion object {
        val EMPTY = NewsItem(
            source = NewsSource.EMPTY,
            author = "",
            title = "",
            description = "",
            url = "",
            urlToImage = "",
            publishedAt = "",
            content = ""
        )
    }
}