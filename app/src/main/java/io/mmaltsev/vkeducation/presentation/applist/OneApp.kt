package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
internal fun OneApp(
    app: AppDetails,
    modifier: Modifier = Modifier,
    compact: Boolean = false,
    onClick: () -> Unit = {},
) {
    val corner = if (compact) 16.dp else 32.dp
    val outerPadding = if (compact) 8.dp else 32.dp
    val iconPadding = if (compact) 4.dp else 32.dp
    val iconSize = if (compact) 48.dp else 256.dp
    val nameStyle = if (compact) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge
    val descriptionStyle = if (compact) MaterialTheme.typography.bodySmall else MaterialTheme.typography.titleSmall
    val categoryStyle = if (compact) MaterialTheme.typography.labelSmall else MaterialTheme.typography.titleSmall
    val textAlign = if (compact) TextAlign.Center else null

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(corner))
            .background(color = Color(0xFF625b71))
            .clickable(onClick = onClick)
            .padding(outerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .padding(iconPadding)
                .clip(RoundedCornerShape(corner))
                .background(color = Color(0xAAFFFFFF)),
        ) {
            Icon(
                imageVector = app.icon,
                modifier = Modifier.size(iconSize),
                tint = Color(0xFF000000),
                contentDescription = null,
            )
        }
        Text(
            text = app.name,
            style = nameStyle.copy(fontWeight = FontWeight.Bold),
            textAlign = textAlign,
            maxLines = if (compact) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = app.description,
            style = descriptionStyle,
            textAlign = textAlign,
            maxLines = if (compact) 2 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = app.category,
            style = categoryStyle.copy(fontWeight = FontWeight.Bold),
            textAlign = textAlign,
            maxLines = if (compact) 1 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        OneApp(
            app = AppDetails(1, "Инструменты", Icons.Filled.Build, "Набор полезных утилит", "Утилиты"),
        )
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
private fun CompactPreview() {
    VkEducationTheme {
        OneApp(
            app = AppDetails(1, "Инструменты", Icons.Filled.Build, "Набор полезных утилит", "Утилиты"),
            compact = true,
        )
    }
}
