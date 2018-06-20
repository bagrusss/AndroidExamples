package ru.bagrusss.clean_mvvm.network

import io.reactivex.Single

/**
 * Created by bagrusss on 19.06.18
 */
interface NetworkSender {

    fun getHelloForUser(userId: String): Single<String>
}