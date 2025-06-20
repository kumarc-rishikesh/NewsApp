package com.example.newsapp.feature_news_page.domain.model

data class NewsSource(
    val id: String?,
    val name: String
){
    companion object {
        val EMPTY = NewsSource(
            id = null,
            name = ""
        )
    }
}