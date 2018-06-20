package ru.bagrusss.clean_mvvm.storage

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.bagrusss.clean_mvvm.entity.User

/**
 * Created by bagrusss on 19.06.18
 */
interface UserStorage {
    fun getUserName(): Single<String>
    fun getActiveUserId(): Single<String>
    fun dropUser(): Completable

    fun getUser(): Maybe<User>
    fun storeUser(user: User): Completable

}