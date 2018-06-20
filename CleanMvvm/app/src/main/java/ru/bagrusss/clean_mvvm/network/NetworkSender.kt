package ru.bagrusss.clean_mvvm.network

import io.reactivex.Single
import ru.bagrusss.clean_mvvm.entity.User

/**
 * Created by bagrusss on 19.06.18
 */
interface NetworkSender {

    fun getHelloForUser(userId: String): Single<String>

    fun getUserById(userId: String): Single<User>
}