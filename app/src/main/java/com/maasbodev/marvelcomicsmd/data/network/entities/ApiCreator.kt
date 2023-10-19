package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiCreator(
	val id: Int,
	val firstName: String,
	val middleName: String,
	val lastName: String,
	val suffix: String,
	val fullName: String,
	val modified: String,
	val resourceURI: String,
	val urls: List<ApiUrl>,
	val thumbnail: ApiThumbnail,
	val series: List<ApiSeries>,
	val stories: List<ApiStory>,
	val comics: List<ApiComic>,
	val events: List<ApiComic>,
)
