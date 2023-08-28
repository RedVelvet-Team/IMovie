package com.redvelvet.usecase.usecase

import com.redvelvet.entities.Player
import com.redvelvet.entities.error.ValidationException
import com.redvelvet.usecase.repository.MovieRepository
import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCase
import javax.inject.Inject

class GetPlayerInfoUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val checkUserLoggedIn: CheckUserLoggedInUseCase
) {
    suspend fun getPlayerScore(): Player{
       return repository.getPlayerInfo()
    }

    suspend fun getHighestScorePlayer(): List<Player>{
       return repository.getHighestScorePlayer()
    }

    suspend fun updatePlayerScore(score: Int){
        repository.savePlayerScore(score)
    }

    suspend fun addPlayer(){
        if (checkUserLoggedIn.isLoggedInByAccount()){
//            repository.addPlayer()
        }else{
            throw ValidationException("you don't have an account")
        }
    }
}