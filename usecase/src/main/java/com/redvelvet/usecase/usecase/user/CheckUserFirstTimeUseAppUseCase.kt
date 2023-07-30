package com.redvelvet.usecase.usecase.user


interface CheckUserFirstTimeUseAppUseCase {
    suspend operator fun invoke(): Boolean
}