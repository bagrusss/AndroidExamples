package ru.bagrusss.clean_mvvm.mvvm

import android.databinding.ViewDataBinding

/**
 * Created by bagrusss on 29.05.2018
 */
abstract class DefaultMvvmFragment<DB: ViewDataBinding, VM: DefaultViewModel>: MvvmFragment<DB, VM, LifecycleHandler<VM>>() {

    override fun provideLifecycleHandler() = LifecycleHandler(viewModel)

}