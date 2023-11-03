package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.models.input.LoginInputBO
import com.gonzalez.blanchard.domain.repository.IAuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: IAuthRepository,
) : UseCase<LoginInputBO, Unit>() {

    override suspend fun useCaseFunction(input: LoginInputBO) {
        authRepository.login(input.user, input.password)
    }
}
