package com.ss.android.auto.domain.commands

interface Command<T> {
    fun execute(): T
}