package com.github.demo.profile.di

import com.github.demo.profile.ui.model.Random
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class ProfileFragmentModule {

    @Provides
    fun provideRandon(): Random {
        return Random()
    }
}
