package ru.bagrusss.clean_mvvm.screens.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import ru.bagrusss.clean_mvvm.R
import ru.bagrusss.clean_mvvm.interactors.DemoInteractor
import ru.bagrusss.clean_mvvm.mvvm.DefaultViewModel
import ru.bagrusss.clean_mvvm.mvvm.EmptyLiveData
import ru.bagrusss.clean_mvvm.rx.plusAssign
import javax.inject.Inject

/**
 * Created by bagrusss on 19.06.18
 */
class MainVM: DefaultViewModel() {

    @JvmField val helloText = ObservableField<String>()

    @Inject lateinit var demoInteractor: DemoInteractor

    val textUpdateEvent = MutableLiveData<String>()

    // можно сделать через databinding, но это демо и представим, что здесь сложная вьюха
    val showProgressEvent = EmptyLiveData()
    val hideProgressEvent = EmptyLiveData()

    fun buttonClicked() {
        showProgressEvent.post()
        disposables += demoInteractor.interact()
                                     .subscribe({
                                         helloText.set(it)
                                         textUpdateEvent.value = "Обновлено"
                                         hideProgressEvent.post()
                                     }) {
                                         val defaultErrorText = resourceProvider.get().provideString(R.string.error)
                                         helloText.set(defaultErrorText)
                                         hideProgressEvent.post()
                                     }
    }

}