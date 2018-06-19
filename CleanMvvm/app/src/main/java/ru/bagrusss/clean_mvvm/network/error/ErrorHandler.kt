package ru.bagrusss.clean_mvvm.network.error

/**
 * Created by bagrusss on 19.06.18
 */
interface ErrorHandler {
    fun handleServerError(t: Throwable)
}