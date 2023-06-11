package com.github.demo.ui

import androidx.lifecycle.ViewModel
import com.github.demo.core.di.qualifiers.ProfileMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    @ProfileMessage private val profileMessage: String // Обратите внимание. Сюда мы можем заинжектить строку из профиля а в саму активити нет!
    // Потому что ProfileMessage находится под компонентом viewmodel!
) : ViewModel() {

}
