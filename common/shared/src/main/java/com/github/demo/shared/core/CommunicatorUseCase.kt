package com.github.demo.shared.core

import com.github.demo.shared.core.entity.Event
import com.github.demo.shared.core.entity.Status
import kotlinx.coroutines.flow.Flow

interface CommunicatorUseCase {
    
    val statusFlow: Flow<Status?>
    
    val eventFlow: Flow<Event?>

    fun sendEvent(event: Event)

    fun sendStatus(status: Status)

    fun closeCommunication()
}