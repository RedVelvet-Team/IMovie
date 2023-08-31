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
    override suspend fun getUserScore(accountId: Int): Pair<PlayerDto, Int> {
        val result = getAllPlayers()
        return ((result.find { it.accountId == accountId }
            ?: PlayerDto()) to result.indexOfFirst { it.accountId == accountId })
    }

    override suspend fun getHighestScorePlayers(): List<Pair<PlayerDto, Int>> {
        return getAllPlayers().take(5).mapIndexed{index, playerDto -> playerDto to index }
    }

    private suspend fun getAllPlayers(): List<PlayerDto> {
        val result = mutableListOf<PlayerDto>()
        fireStore.collection(GAME_COLLECTION)
            .orderBy(SCORE, Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                it.documents.forEach { document ->
                    result.add(document?.toObject(PlayerDto::class.java) ?: PlayerDto())
                }
            }.addOnFailureListener { throw it }
            .await()
        delay(2000)
        return result
    }

    override suspend fun saveUserScore(score: Int, accountId: Int) {
        Log.v("mohamed", "score , $score")
        val playerRef = fireStore.collection(GAME_COLLECTION).document(accountId.toString())
        val currentScore = playerRef.get().await().getLong(SCORE) ?: 0L
        Log.v("mohamed", "score lfeoegve")
        Log.v("mohamed", "score $currentScore, $score")
        playerRef.update(SCORE, currentScore + score)
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