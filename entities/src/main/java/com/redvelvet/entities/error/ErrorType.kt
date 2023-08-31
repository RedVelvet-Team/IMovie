package com.redvelvet.entities.error

open class MovieException(message: String?): Exception(message)

class NullResultException(message: String?) : MovieException(message)
class BadRequestException(message: String?) : MovieException(message)
open class ValidationException(message: String?): MovieException(message)
class NotFoundException(message: String?): MovieException(message)
open class NetworkException(message: String?): MovieException(message)
class  NoInternetException(message: String?): NetworkException(message)
class ServerException(message: String?) : NetworkException(message)
class DeleteException(message: String?) : MovieException(message)
