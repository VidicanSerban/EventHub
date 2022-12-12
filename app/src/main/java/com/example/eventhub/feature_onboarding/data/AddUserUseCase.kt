package com.example.eventhub.feature_onboarding.data

import kotlinx.coroutines.flow.Flow

class AddUserUseCase constructor(
    private val repository: UserRepositoryImpl
) {
    suspend fun registerUser(email: String, password: String): Flow<Response<User?>> {
        return repository.addUserToFirestore(email, password)
    }
}