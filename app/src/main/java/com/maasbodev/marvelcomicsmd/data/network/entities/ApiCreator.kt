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
    val series: ApiReferenceList,
    val stories: ApiReferenceList,
    val comics: ApiReferenceList,
    val events: ApiReferenceList,
)
