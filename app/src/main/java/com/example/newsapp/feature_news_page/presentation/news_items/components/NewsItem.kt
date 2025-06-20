package com.example.newsapp.feature_news_page.presentation.news_items.components

import android.R
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.newsapp.feature_news_page.domain.model.NewsItem
import com.example.newsapp.feature_news_page.domain.model.NewsSource

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsItem(
    newsItem: NewsItem,
    onClick: () -> Unit
//    modifier: Modifier = Modifier
){
//    TODO(encode urls  URLEncoder.encode(url, StandardCharsets.UTF_8.toString()))
    Row(
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(corner = CornerSize(8.dp)))
            .padding(horizontal = 12.dp, vertical = 12.dp)
            .clickable{onClick()}
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Column(modifier = Modifier.fillMaxWidth(0.7f)){
            Text(
                text = newsItem.title,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1
            )
            Text(
                text = newsItem.author,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = newsItem.publishedAt,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        GlideImage(
            model = newsItem.urlToImage,
            contentDescription = "Translated description of what the image contains",
            modifier = Modifier.fillMaxWidth(0.8f),
            contentScale = ContentScale.Fit
        )
    }
}

val temp = NewsItem(NewsSource("abc", "def"),
    author = "ghikjlll",
    title="alooilfwerugfla32;ou4bgvp;aw3o4bugvp;",
    description = "mno", url="pqr",
    urlToImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc9APxkj0xClmrU3PpMZglHQkx446nQPG6lA&s",
    publishedAt = "2025-06-16T16:31:08Z",
    content = "")


@Preview( showBackground = true)
@Composable
fun NewsItemPreview(modifier: Modifier = Modifier) {
    NewsItem(temp,{})
}