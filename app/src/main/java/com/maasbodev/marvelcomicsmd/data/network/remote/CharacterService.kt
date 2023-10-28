package com.maasbodev.marvelcomicsmd.data.network

import com.maasbodev.marvelcomicsmd.data.network.entities.ApiCharacter
import com.maasbodev.marvelcomicsmd.data.network.entities.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {
	@GET("characters")
	suspend fun getCharacters(
		@Query("offset") offset: Int,
		@Query("limit") limit: Int,
	): ApiResponse<ApiCharacter>
}