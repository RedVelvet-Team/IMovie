package com.redvelvet.repository

sealed class RemoteError : Exception() {
    object NullData : RemoteError()
    object  Network: RemoteError()
    object AuthenticationFailed : RemoteError()
    object InvalidApiKey : RemoteError()
    object ServiceOffline : RemoteError()
    object SuspendedApiKey : RemoteError()
    object InternalError : RemoteError()
    object AuthenticationFailed2 : RemoteError()
    object Failed : RemoteError()
    object DeviceDenied : RemoteError()
    object SessionDenied : RemoteError()
    object BackendTimeout : RemoteError()
    object UsernamePasswordRequired : RemoteError()
    object InvalidUsernamePassword : RemoteError()
    object AccountDisabled : RemoteError()
    object EmailNotVerified : RemoteError()
    object InvalidRequestToken : RemoteError()
    object InvalidToken : RemoteError()
    object InsufficientPermissions : RemoteError()
    object ResourcePrivate : RemoteError()
    object ConnectionError : RemoteError()
    object InvalidId : RemoteError()
    object MaintenanceMode : RemoteError()
    object InvalidInput : RemoteError()
}