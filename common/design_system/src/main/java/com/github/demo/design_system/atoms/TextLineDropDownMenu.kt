import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.demo.design_system.theme.DemoTheme

@Composable
fun TextLineDropDownMenu(
    title: String,
    itemList: List<String>,
    selectedItemPos: Int = 0,
    onItemSelected: (position: Int) -> Unit
) {
    ComposableDropDownMenu(
        title = title,
        defaultSubTitle = itemList[selectedItemPos]
    ) { expandedState, subTitle ->
        itemList.forEachIndexed { index, selectionOption ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(DemoTheme.colors.background)
                    .clickable {
                        onItemSelected.invoke(index)
                        expandedState.value = false
                        subTitle.value = itemList[index]
                    }
                    .padding(16.dp),
                text = selectionOption,
                color = DemoTheme.extendedColors.textPrimary
            )
        }
    }
}

@Composable
@Preview
private fun TextLineDropDownMenuPreview() {
    DemoTheme {
        TextLineDropDownMenu(
            title = "My Title",
            itemList = listOf("First", "Second", "Third"),
            selectedItemPos = 0,
            onItemSelected = {}
        )
    }
}
