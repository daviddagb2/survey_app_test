package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.repository.IAuthRepository
import javax.inject.Inject

class RecoverPasswordUseCase @Inject constructor(
    private val authRepository: IAuthRepository,
) : UseCase<Unit, Unit>() {

    override suspend fun useCaseFunction(input: Unit) {
        // TODO: authRepository.recoverPassword()
    }
}
