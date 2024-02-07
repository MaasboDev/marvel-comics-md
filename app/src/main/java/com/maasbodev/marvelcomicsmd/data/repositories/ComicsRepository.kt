package com.maasbodev.marvelcomicsmd.data.repositories

import com.maasbodev.marvelcomicsmd.data.Result
import com.maasbodev.marvelcomicsmd.data.network.remote.ComicsService
import com.maasbodev.marvelcomicsmd.data.tryCall
import com.maasbodev.marvelcomicsmd.domain.entities.Comic
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val service: ComicsService) {

    suspend fun get(format: Comic.Format? = null): Result<List<Comic>> =
        tryCall {
            service
                .getComics(0, 10, format?.toStringFormat())
                .data
                .results
                .map { it.asComic() }
        }

    suspend fun find(id: Int): Result<Comic> =
        tryCall {
            service
                .findComic(id)
                .data
                .results
                .first()
                .asComic()
        }
}
