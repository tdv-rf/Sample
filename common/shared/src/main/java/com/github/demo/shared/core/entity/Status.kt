package com.github.demo.shared.core.entity

sealed class Status {
    data class OnClick(
        val code: String
    ): Status()
}