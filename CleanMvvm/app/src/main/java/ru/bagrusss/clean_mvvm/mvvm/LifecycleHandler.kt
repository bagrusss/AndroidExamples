package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper

/**
 * Created by bagrusss on 23.05.2018
 */
open class LifecycleHandler<out VM : ViewModel>(protected val viewModel: VM) : LifecycleObserver {

    protected var isStarted = false

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {
        isStarted = true
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {
        isStarted = false
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {

    }

}