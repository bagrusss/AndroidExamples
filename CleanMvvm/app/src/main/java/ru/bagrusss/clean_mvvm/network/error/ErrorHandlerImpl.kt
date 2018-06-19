package ru.bagrusss.clean_mvvm.network.error

import retrofit2.HttpException
import ru.bagrusss.clean_mvvm.storage.UserStorage

/**
 * Created by bagrusss on 19.06.18
 */
class ErrorHandlerImpl(private val userStorage: UserStorage): ErrorHandler {

    override fun handleServerError(t: Throwable) {
        if (t is HttpException) {
            if (t.code() == 401) {
                userStorage.dropUser()
                           .blockingAwait()
            }
        }
    }
}