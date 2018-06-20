package ru.bagrusss.clean_mvvm.provider

/**
 * Created by bagrusss on 20.06.2018
 */
interface ResourceProvider {
    fun provideString(resId: Int): String
    fun provideColor(resId: Int): Int
}