package com.redvelvet.remote.util

import com.redvelvet.repository.RemoteError

object RemoteErrorMap {
    val remoteErrorMap = mapOf(
        3 to RemoteError.AuthenticationFailed,
        7 to RemoteError.InvalidApiKey,
        9 to RemoteError.ServiceOffline,
        10 to RemoteError.SuspendedApiKey,
        11 to RemoteError.InternalError,
        14 to RemoteError.AuthenticationFailed2,
        15 to RemoteError.Failed,
        16 to RemoteError.DeviceDenied,
        17 to RemoteError.SessionDenied,
        24 to RemoteError.BackendTimeout,
        26 to RemoteError.UsernamePasswordRequired,
        30 to RemoteError.InvalidUsernamePassword,
        31 to RemoteError.AccountDisabled,
        32 to RemoteError.EmailNotVerified,
        33 to RemoteError.InvalidRequestToken,
        35 to RemoteError.InvalidToken,
        36 to RemoteError.InsufficientPermissions,
        39 to RemoteError.ResourcePrivate,
        43 to RemoteError.ConnectionError,
        44 to RemoteError.InvalidId,
        46 to RemoteError.MaintenanceMode,
        47 to RemoteError.InvalidInput
    ).withDefault { RemoteError.InternalError }
}