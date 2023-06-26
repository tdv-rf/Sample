package com.github.demo.home_screen.domain

import com.github.demo.shared.core.NoDefaultInitUseCase

class NoDefaultInitUseCaseImpl() : NoDefaultInitUseCase {

    init {
        println("New instance NoDefaultInitUseCase")
    }
}