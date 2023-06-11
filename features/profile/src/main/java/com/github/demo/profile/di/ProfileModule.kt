package com.github.demo.profile.di

import com.github.demo.core.di.qualifiers.ProfileMessage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ProfileModule {

    @ProfileMessage
    @Provides
    fun provideProfileMessage(): String {
        return "Это сообщение модулю Профиль"
    }
}
