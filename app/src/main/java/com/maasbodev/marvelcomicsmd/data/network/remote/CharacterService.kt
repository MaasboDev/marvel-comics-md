package com.maasbodev.marvelcomicsmd.data.network.remote

import com.maasbodev.marvelcomicsmd.data.network.entities.ApiCharacter
import com.maasbodev.marvelcomicsmd.data.network.entities.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): ApiResponse<ApiCharacter>

    @GET("characters/{characterId}")
    suspend fun findCharacter(
        @Path("characterId") characterId: Int,
    ): ApiResponse<ApiCharacter>
}
