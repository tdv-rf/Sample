package com.github.demo.design_system.theme.colors

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.github.demo.design_system.theme.colors.entity.GradientSchemeBrushes

object Colors {
    val Green500 = Color(0xFF52AE30)
    val Yellow500 = Color(0xFFFFEB3B)
    val Black950 = Color(0xFF0D0D0D)
    val Black500 = Color(0xFF414040)
    val White100 = Color(0xFFFFFFFF)
}

internal class LightGradients: GradientSchemeBrushes {

    override val greenWhite0: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFD7E4D2),
            Color(0xFFFFFFFF)
        )
    )
}

internal class DarkGradients: GradientSchemeBrushes {

    override val greenWhite0: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF1C2717),
            Color(0xFF141414)
        )
    )
}
