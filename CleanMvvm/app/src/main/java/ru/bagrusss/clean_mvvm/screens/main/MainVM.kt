package ru.bagrusss.clean_mvvm.screens.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import ru.bagrusss.clean_mvvm.interactors.DemoInteractor
import ru.bagrusss.clean_mvvm.mvvm.DefaultViewModel
import ru.bagrusss.clean_mvvm.rx.plusAssign
import javax.inject.Inject

/**
 * Created by bagrusss on 19.06.18
 */
class MainVM: DefaultViewModel() {

    @JvmField val helloText = ObservableField<String>()

    @Inject lateinit var demoInteractor: DemoInteractor

    val textUpdateEvent = MutableLiveData<String>()

    fun buttonClicked() {
        disposables += demoInteractor.interact()
                                     .subscribe({
                                         helloText.set(it)
                                         textUpdateEvent.value = "Обновлено"
                                     }) {
                                         helloText.set("Что-то пошло не так")
                                     }
    }

}