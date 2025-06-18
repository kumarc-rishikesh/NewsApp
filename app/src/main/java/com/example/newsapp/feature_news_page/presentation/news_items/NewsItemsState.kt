package com.example.newsapp.feature_news_page.presentation.news_items

import com.example.newsapp.feature_news_page.domain.model.NewsItem

data class NewsItemsState(
    val newsItems : List<NewsItem> = emptyList()
)