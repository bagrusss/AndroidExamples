package ru.bagrusss.clean_mvvm.network.api

import ru.bagrusss.clean_mvvm.rx.single

/**
 * Created by bagrusss on 20.06.2018
 */
class UserApiFakeImpl: UserApi {

    override fun getHelloForUser(usetId: String) = single {
        Thread.sleep(3000)
        "Привет, $usetId"
    }

}