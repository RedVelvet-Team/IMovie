package com.redvelvet.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.redvelvet.entities.error.NullResultException
import com.redvelvet.firebase.util.Constants
import com.redvelvet.firebase.util.wrapRealTimeCall
import com.redvelvet.repository.dto.party.MoviePartyDto
import com.redvelvet.repository.source.RealTimeDataSource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class FirebaseDataSource @Inject constructor(
    private val fireStore: FirebaseFirestore,
) : RealTimeDataSource {
    override suspend fun createRoom(userName: String,partyId:String) {
        val partyRoom = MoviePartyDto(
            id = partyId,
            adminName = userName,
        )
        wrapRealTimeCall {
            fireStore.collection(Constants.COLLECTION_NAME).document(partyId).set(partyRoom).await()
        }
    }


    override suspend fun joinRoom(id: String) {
        wrapRealTimeCall {
            fireStore.collection(Constants.COLLECTION_NAME).document(id).get().await().data
                ?: throw NullResultException(message = "Wrong room id")
        }
    }

    override suspend fun streamMovie(roomId: String): Flow<MoviePartyDto> {
        return callbackFlow {
            val listener = fireStore.collection(Constants.COLLECTION_NAME)
                .document(roomId)
                .addSnapshotListener { snapshot, error ->
                    if (error != null) {
                        return@addSnapshotListener
                    }

                    val data = snapshot?.toObject<MoviePartyDto>()
                    data?.let {
                        trySend(it)
                    }
                }

            awaitClose { listener.remove() }
        }

    }

}