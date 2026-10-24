package io.mmaltsev.vkeducation.presentation.applist

import android.app.ActivityManager
import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.vector.ImageVector

data class AppDetails(
    val id: Int,
    val name: String,
    val icon: ImageVector,
    val description: String,
    val category: String,
)
