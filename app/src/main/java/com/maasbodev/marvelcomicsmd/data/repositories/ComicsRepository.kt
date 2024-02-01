package com.maasbodev.marvelcomicsmd.data.repositories

import com.maasbodev.marvelcomicsmd.data.entities.Comic
import com.maasbodev.marvelcomicsmd.data.entities.Result
import com.maasbodev.marvelcomicsmd.data.entities.tryCall
import com.maasbodev.marvelcomicsmd.data.network.remote.ComicsService
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val service: ComicsService) {

    suspend fun get(format: Comic.Format? = null): Result<List<Comic>> = tryCall {
        service
            .getComics(0, 10, format?.toStringFormat())
            .data
            .results
            .map { it.asComic() }
    }

    suspend fun find(id: Int): Result<Comic> = tryCall {
        service
            .findComic(id)
            .data
            .results
            .first()
            .asComic()
    }
}
