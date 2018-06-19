package ru.bagrusss.clean_mvvm.screens.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import ru.bagrusss.clean_mvvm.mvvm.DefaultViewModel

/**
 * Created by bagrusss on 19.06.18
 */
class MainVM: DefaultViewModel() {

    @JvmField val textObservable = ObservableField<String>()

    val textUpdateEvent = MutableLiveData<String>()

}