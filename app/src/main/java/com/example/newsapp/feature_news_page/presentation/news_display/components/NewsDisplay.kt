package com.example.newsapp.feature_news_page.presentation.news_display.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.example.newsapp.feature_news_page.domain.model.NewsSource

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsDisplay(
    newsItem: NewsItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        GlideImage(
            model = newsItem.urlToImage,
            contentDescription = "Translated description of what the image contains",
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(.4f),
            contentScale = ContentScale.Fit
        )
        Text(
           text = newsItem.title
        )
    }
}

val temp = NewsItem(
    NewsSource.EMPTY,
    author = "AuthorName",
    title = "TITLE OF THE NEWS ARTICLE. THIS CAN BE VERY LONG ALSO. IT NEEDS TO BE IN 2 LINES OR ONE LINE",
    description = "Description of the image",
    url = "www.google.com",
    urlToImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc9APxkj0xClmrU3PpMZglHQkx446nQPG6lA&s",
    publishedAt = "2025-06-16T16:31:08Z",
    content = "Prime Day 2025 is fast approaching, officially kicking off on July 8 and lasting a whole four days through to 11:59 PM PT on July 11. That's the biggest Prime Day event since its inception around a d… [+8693 chars]",
)

@Preview(showBackground = true)
@Composable
fun NewsDisplayPreview(modifier: Modifier= Modifier){
    NewsDisplay(newsItem = temp)
}