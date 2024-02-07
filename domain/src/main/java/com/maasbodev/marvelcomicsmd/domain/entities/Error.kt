package com.maasbodev.marvelcomicsmd.domain.entities

sealed class Error {
    class Server(val code: Int) : Error()
    object Connectivity : Error()
    class Unknown(val message: String) : Error()
}
