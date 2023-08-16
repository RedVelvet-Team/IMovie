package com.redvelvet.entities.actor

data class Actor(
    val id: Int,
    val name: String,
    val profileImageUrl: String,
    val birthday: String,
    val placeOfBirth: String,
    val biography: String,
    val knownForDepartment: String,
    val alsoKnownAs: String
)