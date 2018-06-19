package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable

abstract class DefaultViewModel: ViewModel() {

    protected val disposables = CompositeDisposable()

    @CallSuper
    override fun onCleared() {
        disposables.dispose()
    }

    open fun onBackPressed() = true

}