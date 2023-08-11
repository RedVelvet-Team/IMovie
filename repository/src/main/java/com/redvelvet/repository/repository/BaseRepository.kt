package com.redvelvet.repository.repository

import com.redvelvet.entities.error.MovieError
import com.redvelvet.entities.error.NetworkError
import com.redvelvet.entities.error.NullResultError
import com.redvelvet.entities.error.ServerError
import com.redvelvet.entities.error.ValidationError
import com.redvelvet.repository.util.NoInternetException
import com.redvelvet.repository.util.NullResultException
import com.redvelvet.repository.util.RemoteException
import com.redvelvet.repository.util.ServerException
import com.redvelvet.repository.util.ValidationException

open class BaseRepository {
    protected suspend fun <T> wrapRemoteResponse(response: suspend () -> T): T {
        return try {
            response()
        } catch (e: NoInternetException) {
            throw NetworkError()
        }catch (e: NullResultException){
            throw NullResultError()
        }catch (e: ServerException){
            throw ServerError()
        }catch (e: ValidationException){
            throw ValidationError()
        }catch (e: RemoteException){
            throw MovieError()
        }
    }
}