package com.maasbodev.marvelcomicsmd.data.repositories

import com.maasbodev.marvelcomicsmd.data.entities.Character
import com.maasbodev.marvelcomicsmd.data.network.ApiClient
import com.maasbodev.marvelcomicsmd.data.network.entities.asString

object CharactersRepository {

	suspend fun getCharacters(offset: Int): List<Character> {
		val result = ApiClient.marvelService.getCharacters(offset, 100)

		return result.data.results.map {
			Character(it.id, it.name, it.description, it.thumbnail.asString())
		}
	}
}