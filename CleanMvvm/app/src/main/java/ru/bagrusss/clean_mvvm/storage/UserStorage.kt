package ru.bagrusss.clean_mvvm.storage

import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by bagrusss on 19.06.18
 */
interface UserStorage {
    fun getUserName(): Single<String>
    fun getActiveUserId(): Single<String>
    fun dropUser(): Completable
}