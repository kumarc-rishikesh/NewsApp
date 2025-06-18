package com.example.newsapp.feature_news_page.presentation.news_items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.feature_news_page.presentation.news_items.components.NewsItem
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp

@Composable
fun NewsItemScreen(
    navController: NavController,
    viewModel: NewsItemsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
            ){
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(state.newsItems) { newsItem ->
                        NewsItem(newsItem, Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.size(5.dp))
                    }
                }
                Spacer(modifier = Modifier.size(24.dp))
            }
        }
    )
}
