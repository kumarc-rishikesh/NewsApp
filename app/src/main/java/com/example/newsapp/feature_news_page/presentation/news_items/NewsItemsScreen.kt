package com.example.newsapp.feature_news_page.presentation.news_items

import androidx.compose.foundation.clickable
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
import com.example.newsapp.feature_news_page.presentation.utils.Screen
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun NewsItemScreen(
    navController: NavController,
    viewModel: NewsItemsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    fun String.sanitizeForNavigation(): String {
        val truncated = if (this.length > 100) this.substring(0, 100) + "..." else this

        // 2. Replace newlines and other problematic characters
        return truncated
            .replace("\n", " ")
            .replace("\r", " ")
            .replace("\"", "'")
            .replace("?", "")
            .replace("[", "")
            .replace("]", "")
            .replace("{", "")
            .replace("}", "")
            .replace(Regex("\\s+"), " ")
            .trim()
    }

//    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
            ){
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(state.newsItems) { newsItem ->
                        val url = URLEncoder.encode(newsItem.url.sanitizeForNavigation(), StandardCharsets.UTF_8.toString())
                        val urlToImage = URLEncoder.encode(newsItem.urlToImage, StandardCharsets.UTF_8.toString())
                        val title = String(newsItem.title.sanitizeForNavigation().toByteArray(),Charsets.UTF_8)
                        val description = String(newsItem.description.sanitizeForNavigation().toByteArray(),Charsets.UTF_8)
                        val author = String(newsItem.author.sanitizeForNavigation().toByteArray(),Charsets.UTF_8)
                        val content = String(newsItem.content.sanitizeForNavigation().toByteArray(),Charsets.UTF_8)
                        val publishedAt = String(newsItem.publishedAt.sanitizeForNavigation().toByteArray(),Charsets.UTF_8)
                        NewsItem(newsItem,
                            onClick = {
                                val navigationRoute = buildString {
                                    append(Screen.NewsDisplayScreen.route)
                                    append("?author=").append(author)
                                    append("&title=").append(title)
                                    append("&description=").append(description)
                                    append("&url=").append(url)
                                    append("&urlToImage=").append(urlToImage)
                                    append("&publishedAt=").append(publishedAt)
                                    append("&content=").append(content)
                                }

                                navController.navigate(navigationRoute)
                            }
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                    }
                }
                Spacer(modifier = Modifier.size(24.dp))
            }
        }
    )
}
