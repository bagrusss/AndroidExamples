package ru.bagrusss.clean_mvvm.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.bagrusss.clean_mvvm.network.model.RawUser

/**
 * Created by bagrusss on 19.06.18
 */
interface UserApi {

    @GET("/users/{userId}/hello")
    fun getHelloForUser(@Path("userId") userId: String): Single<String>

    @GET("/users/{userId}")
    fun getUserById(@Path("userId") userId: String): Single<RawUser>

}