package com.redvelvet.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.redvelvet.repository.dto.PlayerDto
import com.redvelvet.repository.source.RealTimeDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class FirebaseDataSource @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val auth: FirebaseAuth
) : RealTimeDataSource {
    override suspend fun getUserScore(accountId: Int): PlayerDto {
        var result = PlayerDto()
        fireStore.collection(GAME_COLLECTION).document(accountId.toString()).get()
            .addOnSuccessListener {
                result = it?.toObject(PlayerDto::class.java) ?: PlayerDto()
            }.addOnFailureListener {
                throw it
            }
        return result
    }

    override suspend fun getHighestScore(): List<PlayerDto> {
        val result = mutableListOf<PlayerDto>()
        fireStore.collection(GAME_COLLECTION)
            .orderBy(SCORE, Query.Direction.DESCENDING).limit(3)
            .get()
            .addOnSuccessListener {
                Log.v("hass", "firebase ${it.documents.size}")
                it.documents.forEach { document ->
                    result.add(document?.toObject(PlayerDto::class.java) ?: PlayerDto())
                }
            }.addOnFailureListener { throw it }
            .await()
        delay(2000)
        return result.also { Log.v("hass", it.toString()) }
    }

    override suspend fun saveUserScore(score: Int, accountId: Int) {
        Log.v("mohamed", "score , $score")
        val playerRef = fireStore.collection(GAME_COLLECTION).document(accountId.toString())
        val currentScore = playerRef.get().await().getLong(SCORE) ?: 0L
        Log.v("mohamed", "score lfeoegve")
        Log.v("mohamed", "score $currentScore, $score")
        playerRef.update(SCORE, currentScore + score)
//            .update(hashMapOf(SCORE to score) as Map<String, Any>)
    }

    override suspend fun addPlayer(player: PlayerDto) {
        fireStore.collection(GAME_COLLECTION).document(player.accountId.toString())
            .set(player)
    }

    private companion object {
        const val GAME_COLLECTION = "game"
        const val SCORE = "score"
    }

}