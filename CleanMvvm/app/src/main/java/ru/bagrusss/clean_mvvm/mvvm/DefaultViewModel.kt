package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import ru.bagrusss.clean_mvvm.provider.ResourceProvider
import javax.inject.Inject

/**
 * Created by bagrusss on 19.06.18
 * ViewModel, которая ничего не знает о контекстных зависимостях
 */

abstract class DefaultViewModel : ViewModel() {

    protected val disposables = CompositeDisposable()

    @Inject lateinit var resourceProvider: dagger.Lazy<ResourceProvider>

    val progressEvent = MutableLiveData<Boolean>()

    @CallSuper
    override fun onCleared() = disposables.dispose()

    open fun onBackPressed() = true

}