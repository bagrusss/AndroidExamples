package ru.bagrusss.clean_mvvm.network.api

import io.reactivex.Single
import ru.bagrusss.clean_mvvm.network.model.RawUser
import ru.bagrusss.clean_mvvm.rx.single
import java.util.concurrent.TimeUnit

/**
 * Created by bagrusss on 20.06.2018
 */
class UserApiFakeImpl : UserApi {

    override fun getHelloForUser(userId: String): Single<String> = single {
        "Привет, $userId"
    }.delay(3, TimeUnit.SECONDS)

    override fun getUserById(userId: String): Single<RawUser> = single {
        RawUser().apply {
            id = "100500"
            firstName = "Test"
            lastName = "Only"
        }
    }.delay(3, TimeUnit.SECONDS)

}