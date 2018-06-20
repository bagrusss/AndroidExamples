package ru.bagrusss.clean_mvvm.network.api

import ru.bagrusss.clean_mvvm.network.model.RawUser
import ru.bagrusss.clean_mvvm.rx.single

/**
 * Created by bagrusss on 20.06.2018
 */
class UserApiFakeImpl: UserApi {

    override fun getHelloForUser(usetId: String) = single {
        Thread.sleep(3000)
        "Привет, $usetId"
    }

    override fun getUserById(userId: String) = single {
        Thread.sleep(3000)
        RawUser().apply {
            id = "100500"
            firstName = "Test"
            lastName = "Only"
        }
    }

}