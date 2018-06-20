package ru.bagrusss.clean_mvvm.network.model

import com.google.gson.annotations.SerializedName
import ru.bagrusss.clean_mvvm.entity.User

/**
 * Created by bagrusss on 20.06.2018
 */
class RawUser: RawModel<User> {

    var id = ""

    @SerializedName("first_name")
    var firstName = ""

    @SerializedName("last_name")
    var lastName = ""

    override fun toEntity(): User {
        return User(id, firstName, lastName)
    }

}