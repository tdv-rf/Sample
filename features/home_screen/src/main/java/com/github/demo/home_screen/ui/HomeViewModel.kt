package com.github.demo.home_screen.ui

import androidx.lifecycle.ViewModel
import com.github.demo.shared.core.CommunicatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val communicatorUseCase: CommunicatorUseCase,
//    private val noDefaultInitUseCase: Provider<NoDefaultInitUseCase>
) : ViewModel() {

    init {
        println("New instance HomeViewModel")
    }

    fun go() {
        println("communicatorUseCase ${communicatorUseCase.hashCode()}")
    }
}
