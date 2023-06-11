package com.github.demo.home_screen.ui

import androidx.lifecycle.ViewModel
import com.github.demo.core.di.qualifiers.AppMessage
import com.github.demo.core.di.qualifiers.HomeScreenMessage
import com.github.demo.core.di.qualifiers.ProfileMessage
import com.github.demo.shared.core.CommunicatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @AppMessage private val appMessage: String,
    @ProfileMessage private val profileMessage: String,
    @HomeScreenMessage private val homeScreenMessage: String,
    private val communicatorUseCase: CommunicatorUseCase
) : ViewModel() {

    init {
        println("HomeViewModel communicatorUseCase instance ${communicatorUseCase.hashCode()}")
    }

    fun printAllMessages() {
        println("appMessage $appMessage")
        println("profileMessage $profileMessage")
        println("homeScreenMessage $homeScreenMessage")
    }
}
