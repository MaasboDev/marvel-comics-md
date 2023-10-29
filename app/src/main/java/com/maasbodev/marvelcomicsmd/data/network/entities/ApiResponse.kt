package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiResponse<T>(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: ApiData<T>,
)
