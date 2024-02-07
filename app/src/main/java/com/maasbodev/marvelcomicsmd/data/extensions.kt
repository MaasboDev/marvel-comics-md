package com.maasbodev.marvelcomicsmd.data

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.maasbodev.marvelcomicsmd.domain.entities.Error
import java.io.IOException
import retrofit2.HttpException

typealias Result<T> = Either<Error, T>

fun Exception.toError(): Error = when (this) {
    is IOException -> Error.Connectivity
    is HttpException -> Error.Server(code())
    else -> Error.Unknown(message ?: "")
}

inline fun <T> tryCall(action: () -> T): Result<T> = try {
    action().right()
} catch (e: Exception) {
    e.toError().left()
}
