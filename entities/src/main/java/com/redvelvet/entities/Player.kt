package com.redvelvet.entities

data class Player(
    val accountId: Int,
    val name: String,
    val score: Int,
    val avatarId: String,
    val rank: Int
)