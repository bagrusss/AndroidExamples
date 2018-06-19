package ru.bagrusss.clean_mvvm.repository

import io.reactivex.Single

/**
 * Created by bagrusss on 19.06.18
 */
interface DemoRepository {
    fun getServerText(): Single<String>
}