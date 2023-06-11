package com.github.demo.profile.ui

import androidx.lifecycle.ViewModel
import com.github.demo.shared.core.CommunicatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val communicatorUseCase: CommunicatorUseCase
) : ViewModel() {

    fun printCommnunicatorUseCaseHashCode() {
        println("ProfileViewModel communicatorUseCase instance ${communicatorUseCase.hashCode()}")
    }

}
