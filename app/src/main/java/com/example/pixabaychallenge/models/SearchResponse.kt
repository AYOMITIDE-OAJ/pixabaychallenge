package com.example.pixabaychallenge.models

data class SearchResponse(
    val totalHits: Int,
    val hits: List<Image>
)
