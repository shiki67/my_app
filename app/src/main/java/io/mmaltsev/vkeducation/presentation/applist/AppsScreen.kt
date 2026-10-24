package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
fun AppsScreen(
    onAppClick: (AppDetails) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { Toolbar(icon = Icons.Filled.Build) },
    ) { innerPadding ->
        AppList(
            apps = hardcodedApps,
            onAppClick = onAppClick,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppsScreenPreview() {
    VkEducationTheme {
        AppsScreen(onAppClick = {})
    }
}
