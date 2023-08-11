package com.redvelvet.entities.error

open class MovieError: Exception()
class NullResultError: NetworkError()
open class NetworkError: MovieError()
class ServerError: NetworkError()
class ValidationError: MovieError()
