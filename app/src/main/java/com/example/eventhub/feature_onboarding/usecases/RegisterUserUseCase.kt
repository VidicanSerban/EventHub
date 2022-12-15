package com.example.eventhub.feature_onboarding.usecases

import com.example.eventhub.feature_onboarding.data.User
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl

class RegisterUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    suspend fun execute(user: User){
        return repository.addUserToRoom(user)
    }
}