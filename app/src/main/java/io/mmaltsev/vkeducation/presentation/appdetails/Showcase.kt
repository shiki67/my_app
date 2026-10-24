package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.presentation.applist.AppDetails
import io.mmaltsev.vkeducation.presentation.applist.OneApp
import io.mmaltsev.vkeducation.presentation.applist.hardcodedApps
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

private const val APPS_PER_PAGE = 3

@Composable
fun Showcase(
    onAppClick: (AppDetails) -> Unit,
    modifier: Modifier = Modifier,
    apps: List<AppDetails> = hardcodedApps.take(APPS_PER_PAGE * 3),
) {
    val pages = apps.chunked(APPS_PER_PAGE)
    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Витрина",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
        ) { page ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                pages[page].forEach { app ->
                    OneApp(
                        app = app,
                        compact = true,
                        onClick = { onAppClick(app) },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowcasePreview() {
    VkEducationTheme {
        Showcase(onAppClick = {})
    }
}
