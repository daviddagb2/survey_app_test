package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.repository.IAuthRepository
import javax.inject.Inject

class RecoverPasswordUseCase @Inject constructor(
    private val authRepository: IAuthRepository,
) : UseCase<String, String>() {

    override suspend fun useCaseFunction(email: String): String {
        return authRepository.recoverPassword(email)
    }
}
