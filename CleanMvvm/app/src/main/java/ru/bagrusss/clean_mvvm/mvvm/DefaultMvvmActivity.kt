package ru.bagrusss.clean_mvvm.mvvm

import android.databinding.ViewDataBinding

abstract class DefaultMvvmActivity<DB : ViewDataBinding, VM : DefaultViewModel> : MvvmActivity<DB, VM, LifecycleHandler>() {

    override fun provideLifecycleHandler() = LifecycleHandler()

}