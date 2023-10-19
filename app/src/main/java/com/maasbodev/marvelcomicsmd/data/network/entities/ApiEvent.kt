package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiEvent(
	val id: Int,
	val title: String,
	val description: String,
	val resourceURI: String,
	val urls: List<ApiUrl>,
	val modified: String,
	val startYear: String,
	val endYear: String,
	val thumbnail: ApiThumbnail,
	val comics: List<ApiComic>,
	val stories: List<ApiStory>,
	val characters: List<ApiCharacter>,
	val creators: List<ApiCreator>,
	val next: ApiVariant,
	val previous: ApiVariant,
)
