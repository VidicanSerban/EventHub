package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    suspend fun returnUser(email: String): Flow<User>{
        return repository.getUserFromRoom(email)
    }
}