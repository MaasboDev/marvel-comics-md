package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiThumbnail(
	val extension: String,
	val path: String,
)

fun ApiThumbnail.asString(): String = "$path.$extension".replace("http", "https")