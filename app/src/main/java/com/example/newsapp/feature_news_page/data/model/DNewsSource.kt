package com.example.newsapp.feature_news_page.data.model

import com.example.newsapp.feature_news_page.domain.model.NewsSource
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DNewsSource(
    @Json(name = "id") val id: String?,
    @Json(name = "name") val name: String
)

fun DNewsSource.toDomainModel():NewsSource = NewsSource(id, name)