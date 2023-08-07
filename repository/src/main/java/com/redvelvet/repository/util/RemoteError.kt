package com.redvelvet.repository.util

open class RemoteException(message: String?): Exception(message)
class NullResultException(message: String?) : RemoteException(message)
class  NoInternetException(message: String?): RemoteException(message)
class ServerException(message: String?): RemoteException(message)
class BadRequestException(message: String?) : RemoteException(message)
open class ValidationException(message: String?): RemoteException(message)
class NotFoundException(message: String?): RemoteException(message)