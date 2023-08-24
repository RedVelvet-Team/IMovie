package com.redvelvet.repository.source

interface RealTimeDataSource {
    suspend fun createRoom(userName: String)

}