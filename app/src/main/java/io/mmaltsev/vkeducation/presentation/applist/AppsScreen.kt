package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun AppsScreen(
    onAppClick: (AppDetails) -> Unit,
) {
    val viewModel = viewModel<AppListViewModel>()
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = viewModel.events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                icon = Icons.Filled.Build,
                onClick = viewModel::onToolbarClick,
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        AppList(
            apps = state.apps,
            onAppClick = onAppClick,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppListEvent>,
    snackbarHostState: SnackbarHostState,
) {
    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppListEvent.ToolbarClicked -> {
                    snackbarHostState.showSnackbar("Вы нажали на тулбар")
                }
            }
        }
    }
}
