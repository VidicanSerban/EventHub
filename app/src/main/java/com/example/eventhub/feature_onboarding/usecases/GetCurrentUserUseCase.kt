package com.example.eventhub.feature_onboarding.usecases

import com.example.eventhub.feature_onboarding.data.User
import com.example.eventhub.feature_onboarding.data.UserRepositoryImpl
import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    fun execute(email: String, password: String): Flow<User>{
        return repository.getUserFromRoom(email, password)
    }
}