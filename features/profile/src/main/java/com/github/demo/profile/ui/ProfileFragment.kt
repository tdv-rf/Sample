package com.github.demo.profile.ui

import TextLineDropDownMenu
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.demo.design_system.theme.DemoTheme
import com.github.demo.profile.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            DemoTheme {
                val state = viewModel.state.collectAsState()
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ProfileFragment",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(48.dp))
                    TextLineDropDownMenu(
                        title = "",
                        itemList = state.value.themeList,
                        selectedItemPos = state.value.selectedPosition,
                        onItemSelected = { position ->
                            viewModel.onThemeSelected(position)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            this@ProfileFragment
                                .findNavController()
                                .navigate(R.id.home_screen)
                        }
                    ) {
                        Text(
                            text = "Navigate to home screen",
                            color = DemoTheme.extendedColors.textPrimary,
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
            }

            SideEffect {
                viewModel.printCommnunicatorUseCaseHashCode()
            }
        }
    }
}
