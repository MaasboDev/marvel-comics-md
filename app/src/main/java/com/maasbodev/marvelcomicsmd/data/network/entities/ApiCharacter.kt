package com.maasbodev.marvelcomicsmd.data.network.entities

data class ApiCharacter(
	val id: Int,
	val name: String,
	val description: String,
	val modified: String,
	val thumbnail: ApiThumbnail,
	val resourceURI: String,
	val comics: ApiReferenceList,
	val series: ApiReferenceList,
	val stories: ApiReferenceList,
	val events: ApiReferenceList,
	val urls: List<ApiUrl>,
)