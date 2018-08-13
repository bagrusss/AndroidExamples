package ru.bagrusss.clean_mvvm.screens.main

import android.arch.lifecycle.MutableLiveData
import ru.bagrusss.clean_mvvm.R
import ru.bagrusss.clean_mvvm.interactors.DemoInteractor
import ru.bagrusss.clean_mvvm.mvvm.DefaultViewModel
import ru.bagrusss.clean_mvvm.rx.plusAssign
import javax.inject.Inject

/**
 * Created by bagrusss on 19.06.18
 */
class MainVM: DefaultViewModel() {

    @Inject lateinit var demoInteractor: DemoInteractor

    val textUpdateEvent = MutableLiveData<String>()

    val newTextEvent = MutableLiveData<String>()

    fun buttonClicked() {
        progressEvent.value = true
        disposables += demoInteractor.interact()
                                     .doOnSubscribe {
                                         newTextEvent.value = null
                                     }
                                     .doFinally {
                                         progressEvent.value = false
                                     }
                                     .subscribe({
                                         newTextEvent.value = it
                                         textUpdateEvent.value = "Обновлено"
                                     }) {
                                         val defaultErrorText = resourceProvider.get().provideString(R.string.error)
                                         newTextEvent.value = defaultErrorText
                                     }
    }

}