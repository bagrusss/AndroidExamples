package ru.bagrusss.clean_mvvm.network.model

/**
 * Created by bagrusss on 20.06.2018
 */
interface RawModel<T> {
    fun toEntity(): T
}