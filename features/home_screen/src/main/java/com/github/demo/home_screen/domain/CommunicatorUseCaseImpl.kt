package com.github.demo.home_screen.domain

import com.github.demo.shared.core.CommunicatorUseCase
import com.github.demo.shared.core.entity.Event
import com.github.demo.shared.core.entity.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CommunicatorUseCaseImpl: CommunicatorUseCase {

    init {
//        println("New instance CommunicatorUseCase")
    }

    private val _statusFlow: MutableStateFlow<Status?> = MutableStateFlow(null)
    private val _eventFlow: MutableStateFlow<Event?> = MutableStateFlow(null)

    override val statusFlow: StateFlow<Status?> = _statusFlow
    override val eventFlow: StateFlow<Event?> = _eventFlow

    override fun sendEvent(event: Event) {
        _eventFlow.value = event
    }

    override fun sendStatus(status: Status) {
        _statusFlow.value = status
    }

    override fun closeCommunication() {
        _statusFlow.value = null
        _eventFlow.value = null
    }
}

