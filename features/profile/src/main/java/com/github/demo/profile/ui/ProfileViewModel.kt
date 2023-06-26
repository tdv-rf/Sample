package com.github.demo.profile.ui

import androidx.lifecycle.ViewModel
import com.github.demo.core.data.ThemeRepository
import com.github.demo.profile.ui.model.ProfileState
import com.github.demo.shared.core.CommunicatorUseCase
import com.github.demo.shared.design_system.ColorTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val communicatorUseCase: CommunicatorUseCase,
) : ViewModel() {

    init {
        println("New instance ProfileViewModel")
    }


    val state: MutableStateFlow<ProfileState> = MutableStateFlow(
        value = ProfileState(
            themeList = ColorTheme
                .values()
                .toList()
                .map { it.name },
            selectedPosition = ThemeRepository
                .getTheme()
                .let { theme ->
                    ColorTheme.values().indexOf(theme)
                }
        )
    )

    fun onThemeSelected(position: Int) {
        val theme = ColorTheme.values()[position]
        ThemeRepository.setTheme(theme)
        state.value = state.value.copy(
            selectedPosition = position
        )
    }

    fun go() {
        println("communicatorUseCase ${communicatorUseCase.hashCode()}")
    }

}
