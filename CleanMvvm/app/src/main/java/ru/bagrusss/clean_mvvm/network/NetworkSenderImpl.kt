package ru.bagrusss.clean_mvvm.network

import io.reactivex.Single
import ru.bagrusss.clean_mvvm.network.api.UserApi
import ru.bagrusss.clean_mvvm.network.error.ErrorHandler

/**
 * Created by bagrusss on 19.06.18
 */
class NetworkSenderImpl(private val userApi: UserApi,
                        private val errorHandler: ErrorHandler): NetworkSender {

    override fun getHelloForUser(userId: String): Single<String> {
        return userApi.getHelloForUser(userId)
                      .doOnError {
                          errorHandler.handleServerError(it)
                      }
    }

}