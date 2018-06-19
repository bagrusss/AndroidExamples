package ru.bagrusss.clean_mvvm.network.api

import io.reactivex.Single

/**
 * Created by bagrusss on 19.06.18
 */
interface UserApi {

    fun getHelloForUser(usetId: String): Single<String>

}