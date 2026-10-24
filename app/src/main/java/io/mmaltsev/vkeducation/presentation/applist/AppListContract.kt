package io.mmaltsev.vkeducation.presentation.applist

data class AppListState(
    val apps: List<AppDetails>,
)

sealed interface AppListEvent {
    data object ToolbarClicked : AppListEvent
}
