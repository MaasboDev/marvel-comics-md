package com.maasbodev.marvelcomicsmd.data.repositories

import com.maasbodev.marvelcomicsmd.data.Result
import com.maasbodev.marvelcomicsmd.data.network.remote.CharacterService
import com.maasbodev.marvelcomicsmd.domain.entities.Character
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val service: CharacterService) :
    Repository<Character>() {

    suspend fun get(): Result<List<Character>> = super.get {
        service
            .getCharacters(0, 100)
            .data
            .results
            .map { it.asCharacter() }
    }

    suspend fun find(id: Int): Result<Character> = super.find(
        id,
        findActionRemote = {
            service
                .findCharacter(id)
                .data
                .results
                .first()
                .asCharacter()
        }
    )
}
