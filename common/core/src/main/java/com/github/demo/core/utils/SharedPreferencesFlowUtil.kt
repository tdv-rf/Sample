package com.github.demo.core.utils

import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onCompletion

inline fun <reified T> SharedPreferences.observeKey(key: String, default: T): Flow<T> {

    val preferenceStateFlow = MutableStateFlow(getItem(key, default))

    val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, updatedPreferenceKey ->
        if (key == updatedPreferenceKey) {
            preferenceStateFlow.value = getItem(key, default)
        }
    }

    registerOnSharedPreferenceChangeListener(listener)

    return preferenceStateFlow
        .onCompletion {
            unregisterOnSharedPreferenceChangeListener(listener)
        }
}

inline fun <reified T> SharedPreferences.getItem(key: String, default: T): T {
    @Suppress("UNCHECKED_CAST")
    return when (default) {
        is String -> getString(key, default) as T
        is String? -> getString(key, default) as T
        is Int -> getInt(key, default) as T
        is Long -> getLong(key, default) as T
        is Boolean -> getBoolean(key, default) as T
        is Float -> getFloat(key, default) as T
        is Set<*> -> getStringSet(key, default as Set<String>) as T
        is MutableSet<*> -> getStringSet(key, default as MutableSet<String>) as T
        else -> throw IllegalArgumentException("Generic type ${T::class.java.name} is not supported")
    }
}