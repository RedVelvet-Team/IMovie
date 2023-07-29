package com.redvelvet.usecase.usecase.user


interface CheckUserFirstTimeUseAppUseCase {
    suspend fun invoke(): Boolean
}