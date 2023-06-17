package com.github.demo.design_system.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import com.github.demo.core.data.ThemeRepository
import com.github.demo.design_system.theme.colors.DarkColorPalette
import com.github.demo.design_system.theme.colors.DarkColorSchemeExtended
import com.github.demo.design_system.theme.colors.DarkGradientBrushes
import com.github.demo.design_system.theme.colors.LightColorPalette
import com.github.demo.design_system.theme.colors.LightColorSchemeExtended
import com.github.demo.design_system.theme.colors.LightGradientBrushes
import com.github.demo.design_system.theme.colors.entity.ColorSchemeExtended
import com.github.demo.design_system.theme.colors.entity.GradientSchemeBrushes
import com.github.demo.shared.design_system.ColorTheme

private val LocalExtendedColorTheme = staticCompositionLocalOf<ColorSchemeExtended> {
    throw IllegalArgumentException("LocalExtendedColorTheme not init")
}
private val LocalGradientBrushes = staticCompositionLocalOf<GradientSchemeBrushes> {
    throw IllegalArgumentException("GradientBrushes not init")
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun DemoTheme(
    content: @Composable () -> Unit
) {
    val initialSystemTheme = if (isSystemInDarkTheme()) ColorTheme.DarkTheme else ColorTheme.LightTheme
    val theme = if (LocalView.current.isInEditMode) {
        mutableStateOf(initialSystemTheme) // Need this for compose preview work
    } else {
        val initialTheme = ThemeRepository.getThemeNoDefault() ?: initialSystemTheme
        ThemeRepository.subscribeOnThemeChange().collectAsState(initial = initialTheme)
    }
    val colors = if (theme.value == ColorTheme.DarkTheme) DarkColorPalette else LightColorPalette
    val extendedColors = if (theme.value == ColorTheme.DarkTheme) DarkColorSchemeExtended else LightColorSchemeExtended
    val gradientBrushes = if (theme.value == ColorTheme.DarkTheme) DarkGradientBrushes else LightGradientBrushes

    CompositionLocalProvider(
        LocalExtendedColorTheme provides extendedColors,
        LocalGradientBrushes provides gradientBrushes,
    ) {
        MaterialTheme(
            colors = colors,
            typography = MaterialTheme.typography,
            shapes = MaterialTheme.shapes,
            content = content
        )
    }
}

object DemoTheme {

    val extendedColors: ColorSchemeExtended
        @Composable
        get() = LocalExtendedColorTheme.current

    val gradientBrushes: GradientSchemeBrushes
        @Composable
        get() = LocalGradientBrushes.current

    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes
}
