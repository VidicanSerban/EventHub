package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    suspend fun execute(id: String): Flow<Response<User?>>{
        return repository.getUserFromFirestore(id)
    }
}