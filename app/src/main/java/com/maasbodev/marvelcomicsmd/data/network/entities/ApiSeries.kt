package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiSeries(
	val id: Int,
	val title: String,
	val description: String,
	val resourceURI: String,
	val urls: List<ApiUrl>,
	val startYear: Int,
	val endYear: Int,
	val rating: String,
	val modified: String,
	val thumbnail: ApiThumbnail,
	val comics: List<ApiComic>,
	val stories: List<ApiStory>,
	val events: List<ApiComic>,
	val characters: List<ApiCharacter>,
	val creators: List<ApiCreator>,
	val next: ApiVariant,
	val previous: ApiVariant,
)
