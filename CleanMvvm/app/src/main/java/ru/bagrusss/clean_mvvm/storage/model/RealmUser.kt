package ru.bagrusss.clean_mvvm.storage.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import ru.bagrusss.clean_mvvm.entity.User

/**
 * Created by bagrusss on 20.06.2018
 */
open class RealmUser: RealmObject() {

    @PrimaryKey
    var id = ""
    var firstName = ""
    var lastName = ""

    internal fun toEntity(): User {
        return User(id, firstName, lastName)
    }
}

fun User.toRealm(): RealmUser {
    val realmUser = RealmUser()
    realmUser.id = id
    realmUser.firstName = firstName
    realmUser.lastName = lastName
    return realmUser
}