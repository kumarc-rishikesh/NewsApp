package com.example.newsapp.feature_news_page.presentation.utils

import androidx.lifecycle.ViewModel
import com.example.newsapp.feature_news_page.domain.model.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {

    private val _selectedNewsItem = MutableStateFlow<NewsItem?>(null)
    val selectedNewsItem: StateFlow<NewsItem?> = _selectedNewsItem

    fun selectNewsItem(newsItem: NewsItem) {
        _selectedNewsItem.value = newsItem
    }
}