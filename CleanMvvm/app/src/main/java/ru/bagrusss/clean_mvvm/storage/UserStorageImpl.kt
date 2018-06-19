package ru.bagrusss.clean_mvvm.storage

import io.reactivex.Completable
import io.reactivex.Single
import ru.bagrusss.clean_mvvm.rx.completable

/**
 * Created by bagrusss on 19.06.18
 */
class UserStorageImpl : UserStorage {

    override fun dropUser(): Completable = completable {

    }

    override fun getUserName(): Single<String> = Single.just("Test user")

    override fun getActiveUserId(): Single<String> = Single.just("100500")
}