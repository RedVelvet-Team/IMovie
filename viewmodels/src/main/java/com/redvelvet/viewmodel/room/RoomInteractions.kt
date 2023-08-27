package com.redvelvet.viewmodel.room

interface RoomInteractions {
    fun onClickCreateRoom(newMovieUrl: String)
    fun onClickJoinRoom(newRoomUrl: String)
    fun onClickCreateRoomLonely()

}