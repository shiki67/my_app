package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
internal fun AppList(
    apps: List<AppDetails>,
    onAppClick: (AppDetails) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(items = apps, key = { it.id }) { app ->
            OneApp(
                app = app,
                onClick = { onAppClick(app) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListPreview() {
    VkEducationTheme {
        AppList(apps = hardcodedApps, onAppClick = {})
    }
}
