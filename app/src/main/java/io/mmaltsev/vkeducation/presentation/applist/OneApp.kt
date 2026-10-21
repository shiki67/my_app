package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
internal fun OneApp(
    app: AppDetails,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(32.dp)).background(color = Color(0xFF625b71)).padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.padding(32.dp).clip(RoundedCornerShape(32.dp)).background(color = Color(0xAAFFFFFF))){
            Icon(
                imageVector = app.icon,
                modifier = Modifier.size(256.dp),
                tint = Color(0xFF000000),
                contentDescription = null,
            )
        }
        Text(
            text = app.name,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
            ),
        )
        Text(
            text = app.description,
            style = MaterialTheme.typography.titleSmall,
        )
        Text(
            text = app.category,
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold
            ),
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