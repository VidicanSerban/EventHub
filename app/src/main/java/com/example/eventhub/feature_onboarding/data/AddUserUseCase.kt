package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

class AddUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    suspend fun execute(email: String, password: String, name: String): Flow<Response<Boolean>> {
        return repository.addUserToFirestore(email, password, name)
    }
}