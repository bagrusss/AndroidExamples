package ru.bagrusss.clean_mvvm.repository

import io.reactivex.Single
import ru.bagrusss.clean_mvvm.network.NetwotkSender
import ru.bagrusss.clean_mvvm.storage.UserStorage

/**
 * Created by bagrusss on 19.06.18
 */
class DemoRepositoryImpl(private val userStorage: UserStorage,
                         private val networkSender: NetwotkSender): DemoRepository {

    override fun getServerText(): Single<String> {
        return userStorage.getActiveUserId()
                          .flatMap { networkSender.getHelloForUser(it) }
    }
}