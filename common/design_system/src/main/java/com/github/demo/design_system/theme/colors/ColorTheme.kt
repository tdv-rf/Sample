package com.github.demo.design_system.theme.colors

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import com.github.demo.design_system.theme.colors.entity.ColorSchemeExtended
import com.github.demo.design_system.theme.colors.entity.GradientSchemeBrushes

/** Dark theme base colors for default elements */
internal val DarkColorPalette = darkColors(
    primary = Colors.Yellow500,
    secondary = Colors.Black500,
    background = Colors.Black950,
    surface = Colors.Black950
)

/** Light theme base colors for default elements */
internal val LightColorPalette = lightColors(
    primary = Colors.Green500,
    secondary = Colors.Black950,
    background = Colors.White100,
    surface = Colors.White100
)

/** Dark theme gradients */
internal val DarkGradientBrushes: GradientSchemeBrushes = DarkGradients()

/** Light theme gradients */
internal val LightGradientBrushes: GradientSchemeBrushes = LightGradients()

/** Light theme non typical colors. Custom colors for special elements */
internal val LightColorSchemeExtended = ColorSchemeExtended(
    brandColor = Colors.Green500,
    textPrimary = Colors.Black950,
)

/** Dark theme non typical colors. Custom colors for special elements */
internal val DarkColorSchemeExtended = ColorSchemeExtended(
    brandColor = Colors.Yellow500,
    textPrimary = Colors.White100,
)
