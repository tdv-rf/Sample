package com.github.demo.home_screen.di

import com.github.demo.core.di.qualifiers.HomeScreenMessage
import com.github.demo.home_screen.domain.NoDefaultInitUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class) // Живет столько же сколько и фрагмент в который внутренние данные инжектятся
class HomeScreenModule {

    @HomeScreenMessage
    @Provides
    // @ViewModelScoped отсутствует. Это означает что даггер будет каждый раз создавать новый инстанс при каждом запросе
    fun provideProfileMessage(): String {
        return "Это сообщение модуля Home screen"
    }

    @Provides
    fun provideNoDefaultInitUseCase(): NoDefaultInitUseCaseImpl = NoDefaultInitUseCaseImpl()

}
