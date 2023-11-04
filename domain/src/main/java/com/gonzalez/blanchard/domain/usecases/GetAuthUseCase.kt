package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.models.AuthTokenBO
import com.gonzalez.blanchard.domain.repository.IAuthRepository
import javax.inject.Inject

class GetAuthUseCase @Inject constructor(
    private val authRepository: IAuthRepository,
) : UseCase<Unit, AuthTokenBO>() {

    override suspend fun useCaseFunction(input: Unit): AuthTokenBO {
        return authRepository.getAuth()
    }
}
