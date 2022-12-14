package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

class RegisterUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    fun execute(user: User){
        return repository.addUserToRoom(user)
    }
}