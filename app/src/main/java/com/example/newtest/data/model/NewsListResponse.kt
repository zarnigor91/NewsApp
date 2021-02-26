package com.example.newtest.data.model

import com.google.gson.annotations.SerializedName


data class NewsListResponse(
    @SerializedName("results")
    val results: List<NewsItem>
)