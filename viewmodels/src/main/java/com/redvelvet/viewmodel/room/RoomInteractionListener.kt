package com.redvelvet.viewmodel.room

interface RoomInteractionListener {
    fun onClickJoinRoom(roomId: String)
    fun onClickCreateRoom(userName: String)
}