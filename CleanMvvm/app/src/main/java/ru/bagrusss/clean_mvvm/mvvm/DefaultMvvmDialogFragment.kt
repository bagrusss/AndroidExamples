package ru.bagrusss.clean_mvvm.mvvm

import android.databinding.ViewDataBinding

/**
 * Created by bagrusss on 05.06.2018
 */
abstract class DefaultMvvmDialogFragment<VM : DefaultViewModel, DB : ViewDataBinding> : MvvmDialogFragment<VM, LifecycleHandler<VM>, DB>() {

    override fun provideLifecycleHandler() = LifecycleHandler(viewModel)

}