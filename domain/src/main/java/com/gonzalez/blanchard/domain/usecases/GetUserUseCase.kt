package com.gonzalez.blanchard.domain.usecases

import com.gonzalez.blanchard.domain.models.UserBO
import com.gonzalez.blanchard.domain.repository.IUserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: IUserRepository,
) : UseCase<Unit, UserBO>() {

    override suspend fun useCaseFunction(input: Unit): UserBO {
        return userRepository.getUser()
    }
}
