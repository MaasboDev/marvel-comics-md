package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiData<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>,
)
