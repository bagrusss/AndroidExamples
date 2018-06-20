package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import ru.bagrusss.clean_mvvm.provider.ResourceProvider
import javax.inject.Inject

abstract class DefaultViewModel: ViewModel() {

    protected val disposables = CompositeDisposable()

    @Inject lateinit var resourceProvider: dagger.Lazy<ResourceProvider>

    @CallSuper
    override fun onCleared() {
        disposables.dispose()
    }

    open fun onBackPressed() = true

}