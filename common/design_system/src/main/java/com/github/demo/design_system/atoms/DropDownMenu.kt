import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.github.demo.design_system.R
import com.github.demo.design_system.theme.DemoTheme

private const val EXPANDED_ANGLE = 180f
private const val COLLAPSED_ANGLE = 0f

@Composable
fun ComposableDropDownMenu(
    title: String,
    defaultSubTitle: String = "",
    modifier: Modifier = Modifier.padding(horizontal = 16.dp),
    titleFontSize: TextUnit = DemoTheme.typography.body1.fontSize,
    titleFontWeight: FontWeight = FontWeight.Normal,
    backgroundColor: Color = DemoTheme.colors.background,
    menuContent: @Composable (
        expandedState: MutableState<Boolean>,
        subTitle: MutableState<String>
    ) -> Unit
) {
    val subTitle: MutableState<String> = remember(defaultSubTitle) { mutableStateOf(defaultSubTitle) }
    val expandedState: MutableState<Boolean> = remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState.value) EXPANDED_ANGLE else COLLAPSED_ANGLE
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(backgroundColor)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .then(modifier)
    ) {
        val lineColor = DemoTheme.extendedColors.brandColor
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable { expandedState.value = !expandedState.value }
                .background(color = DemoTheme.colors.background)
                .drawBehind {
                    val strokeWidth = density
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        lineColor,
                        Offset(0f, y),
                        Offset(size.width, y),
                        strokeWidth
                    )
                }
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    color = DemoTheme.extendedColors.textPrimary
                )
                if (subTitle.value.isNotEmpty()) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = subTitle.value,
                        fontSize = titleFontSize,
                        fontWeight = titleFontWeight,
                        color = DemoTheme.extendedColors.textPrimary
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .wrapContentSize()
                    .rotate(rotationState),
                painter = painterResource(R.drawable.ic_arrow_down),
                tint = DemoTheme.extendedColors.brandColor,
                contentDescription = null
            )
        }
        if (expandedState.value) {
            menuContent.invoke(expandedState, subTitle)
        }
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DarkPreview() {
    ComposableDropDownMenuPreview()
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun LightPreview() {
    ComposableDropDownMenuPreview()
}

@Composable
private fun ComposableDropDownMenuPreview() {
    DemoTheme {
        ComposableDropDownMenu(
            title = "Titile",
            modifier = Modifier.fillMaxWidth(),
        ) { _, _ ->
            listOf("One", "Two", "Three").forEachIndexed { index, selectionOption ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(DemoTheme.colors.background)
                        .padding(16.dp),
                    text = selectionOption,
                    style = DemoTheme.typography.body1,
                    color = DemoTheme.extendedColors.textPrimary
                )
            }
        }
    }
}