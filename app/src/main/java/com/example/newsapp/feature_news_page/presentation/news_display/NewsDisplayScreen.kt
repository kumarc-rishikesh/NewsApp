package com.example.newsapp.feature_news_page.presentation.news_display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.Image
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.example.newsapp.feature_news_page.domain.model.NewsSource
import com.example.newsapp.feature_news_page.presentation.news_display.components.NewsDisplay
import com.example.newsapp.feature_news_page.presentation.news_items.components.NewsItem

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsDisplayScreen(
    navController: NavController,
    author: String,
    title: String,
    description: String,
    url: String,
    urlToImage: String,
    publishedAt: String,
    content: String,
    ) {

    val newsItem = NewsItem(
        source = NewsSource.EMPTY,
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )

    val snackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()
    Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    content = { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
        ){
            NewsDisplay(newsItem)
        }
    }
    )
}

