package com.github.demo.shared.core.entity

sealed class Event {
    object LOAD: Event()
    data class State(
        val message: String
    ): Event()
}