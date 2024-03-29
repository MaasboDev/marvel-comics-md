package com.maasbodev.marvelcomicsmd.data.repositories

import com.maasbodev.marvelcomicsmd.data.Result
import com.maasbodev.marvelcomicsmd.data.tryCall
import com.maasbodev.marvelcomicsmd.domain.entities.MarvelItem

abstract class Repository<T : MarvelItem> {

    private var cache: List<T> = emptyList()

    internal suspend fun get(getAction: suspend () -> List<T>): Result<List<T>> =
        tryCall {
            if (cache.isEmpty()) {
                cache = getAction()
            }
            cache
        }

    internal suspend fun find(
        id: Int,
        findActionRemote: suspend () -> T,
    ): Result<T> =
        tryCall {
            val character = cache.find { it.id == id }
            (character ?: findActionRemote())
        }
}
