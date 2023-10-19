package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiStory(
	val id: Int,
	val title: String,
	val description: String,
	val resourceURI: String,
	val type: String,
	val modified: String,
	val thumbnail: ApiThumbnail,
	val comics: List<ApiComic>,
	val series: List<ApiSeries>,
	val events: List<ApiComic>,
	val characters: List<ApiCharacter>,
	val creators: List<ApiCreator>,
	val originalIssue: ApiVariant,
)
