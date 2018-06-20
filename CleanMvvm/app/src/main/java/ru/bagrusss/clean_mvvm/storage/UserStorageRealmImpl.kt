package ru.bagrusss.clean_mvvm.storage

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmConfiguration
import ru.bagrusss.clean_mvvm.entity.User
import ru.bagrusss.clean_mvvm.rx.completable
import ru.bagrusss.clean_mvvm.rx.maybe
import ru.bagrusss.clean_mvvm.storage.model.RealmUser
import ru.bagrusss.clean_mvvm.storage.model.toRealm

/**
 * Created by bagrusss on 19.06.18
 * Пример хранилища пользователей
 */
class UserStorageRealmImpl(private val config: RealmConfiguration) : UserStorage {

    override fun getUserName(): Single<String> = Single.just("Test user")

    override fun getActiveUserId(): Single<String> = Single.just("100500")

    override fun getUser(): Maybe<User> = maybe {
        Realm.getInstance(config).use {
            it.where(RealmUser::class.java)
              .findFirst()
              ?.toEntity()
        }
    }

    override fun storeUser(user: User) = completable {
        Realm.getInstance(config).use {
            val realmUser = user.toRealm()
            it.insertOrUpdate(realmUser)
        }
    }

    override fun dropUser(): Completable = completable {
        Realm.getInstance(config).use {
            it.delete(RealmUser::class.java)
        }
    }
}