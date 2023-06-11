package com.github.demo.di.module

import com.github.demo.core.di.qualifiers.AppMessage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ApplicationModule {

    @AppMessage
    @Provides
    fun provideAppMessage(): String {
        return "Это сообщение из модуля App"
    }
}
