package com.redvelvet.usecase.repository

interface PartyRepository {
     suspend fun createRoom(userName: String)

     suspend fun joinRoom(id: String)
}