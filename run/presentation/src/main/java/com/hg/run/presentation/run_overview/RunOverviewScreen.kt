@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.hg.run.presentation.run_overview


import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hg.core.presentation.designsystem.AnalyticsIcon
import com.hg.core.presentation.designsystem.LogoIcon
import com.hg.core.presentation.designsystem.LogoutIcon
import com.hg.core.presentation.designsystem.RunIcon
import com.hg.core.presentation.designsystem.BeatTrackTheme
import com.hg.core.presentation.designsystem.components.BeatTrackFloatingActionButton
import com.hg.core.presentation.designsystem.components.BeatTrackScaffold
import com.hg.core.presentation.designsystem.components.BeatTrackToolbar
import com.hg.core.presentation.designsystem.components.util.DropDownItem
import com.hg.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel(),
) {
    RunOverviewScreen(
        onAction = { action ->
            when(action) {
                RunOverviewAction.OnStartClick -> onStartRunClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    BeatTrackScaffold(
        topAppBar = {
            BeatTrackToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.beattrack),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout)
                    ),
                ),
                onMenuItemClick = { index ->
                    when (index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            BeatTrackFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartClick)
                }
            )
        }
    ) { padding ->

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    BeatTrackTheme {
        RunOverviewScreen(
            onAction = {}
        )
    }
}