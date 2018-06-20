package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.MutableLiveData

/**
 * Created by bagrusss on 20.06.2018
 * для отправки пустых сообщений в Activity, Fragment
 */
class EmptyLiveData : MutableLiveData<Unit>() {

    fun post() {
        value = Unit
    }
}