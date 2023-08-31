package com.redvelvet.firebase.util

import com.redvelvet.entities.error.MovieException
import com.redvelvet.entities.error.NetworkException
import com.redvelvet.entities.error.NullResultException
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

suspend fun wrapRealTimeCall(request:suspend () -> Unit){
    try {
        request()

    }catch (e: CancellationException){
        throw NetworkException(e.message)

    }catch (e: IOException){
        throw NetworkException(e.message)

    }catch (e: UnknownHostException){
        throw NetworkException(e.message)

    }catch (e: Exception){
        throw MovieException(e.message)
    }
}


