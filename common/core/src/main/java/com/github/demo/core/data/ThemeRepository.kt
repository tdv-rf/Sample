package com.github.demo.core.data

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import com.github.demo.core.utils.observeKey
import com.github.demo.shared.design_system.ColorTheme
import com.github.demo.shared.design_system.ColorTheme.DarkTheme
import com.github.demo.shared.design_system.ColorTheme.LightTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

object ThemeRepository {

    private const val THEME_KEY = "theme_key"
    private val defaultTheme = ColorTheme.LightTheme

    private lateinit var application: Application

    private val mainPreference: SharedPreferences by lazy {
        application.getSharedPreferences("PREFERENCES_MAIN", Context.MODE_PRIVATE)
    }

    fun init(application: Application) {
        this.application = application
        updateTheme(getTheme())
    }

    fun getThemeNoDefault(): ColorTheme? = mainPreference
        .getString(THEME_KEY, null)
        ?.let { themeString ->
            ColorTheme.valueOf(themeString)
        }

    fun getTheme(): ColorTheme = getThemeNoDefault() ?: defaultTheme

    fun setTheme(theme: ColorTheme) {
        mainPreference
            .edit()
            .putString(THEME_KEY, theme.name)
            .apply()
        updateTheme(theme)
    }

    fun subscribeOnThemeChange(): Flow<ColorTheme?> = mainPreference
        .observeKey(THEME_KEY, "")
        .filter { it.isNotBlank() }
        .map { themeString -> ColorTheme.valueOf(themeString) }

    private fun updateTheme(ColorTheme: ColorTheme) {
        when(ColorTheme) {
            DarkTheme -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            LightTheme -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
