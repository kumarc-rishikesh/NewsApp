package com.example.newsapp.feature_news_page.presentation.utils

sealed class Screen(val route: String) {
    object NewsItemsScreen: Screen("news_items_screen")
    object NewsDisplayScreen: Screen("news_display_screen")
}