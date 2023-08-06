package com.redvelvet.entities.error

open class MovieError: Exception()
class NullResultError: MovieError()
class NetworkError: MovieError()
class ServerError: MovieError()
open class ValidationError: MovieError()

class UnAuthorizedError: ValidationError()
class InvalidUsernameOrPasswordError: ValidationError()
