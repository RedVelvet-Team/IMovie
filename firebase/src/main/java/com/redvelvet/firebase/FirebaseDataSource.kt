package com.redvelvet.firebase

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.redvelvet.entities.error.MovieException
import com.redvelvet.entities.error.NullResultException
import com.redvelvet.firebase.util.Constants
import com.redvelvet.firebase.util.getRandomId
import com.redvelvet.firebase.util.wrapRealTimeCall
import com.redvelvet.repository.dto.party.MoviePartyDto
import com.redvelvet.repository.source.RealTimeDataSource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class FirebaseDataSource @Inject constructor(
    private val fireStore: FirebaseFirestore,
) : RealTimeDataSource {
    override suspend fun createRoom(userName: String) {
        val partyId = getRandomId()
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
            fireStore.collection(Constants.COLLECTION_NAME).document(id).get().await().data?:throw NullResultException(message = "Wrong room id")
        }
    }
}