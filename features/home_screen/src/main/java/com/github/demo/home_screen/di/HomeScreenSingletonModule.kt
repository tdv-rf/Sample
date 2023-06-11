package com.github.demo.home_screen.di

import com.github.demo.home_screen.domain.CommunicatorUseCaseImpl
import com.github.demo.shared.core.CommunicatorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeScreenSingletonModule {


    @Provides
    @Singleton // Этим ограничиваю время жизни CommunicatorUseCase временем жизни HomeScreenSingletonModule на которой установлена аннотация Singleton
    fun provideCommunicatorUseCase(): CommunicatorUseCase {
        return CommunicatorUseCaseImpl()
    }

}
