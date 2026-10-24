package io.mmaltsev.vkeducation.presentation.applist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class AppListViewModel : ViewModel() {

    private val _state = MutableStateFlow(AppListState(apps = hardcodedApps))
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(Channel.BUFFERED)
    val events: Flow<AppListEvent> = _events.receiveAsFlow()

    fun onToolbarClick() {
        _events.trySend(AppListEvent.ToolbarClicked)
    }
}
