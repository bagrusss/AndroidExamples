package ru.bagrusss.clean_mvvm.mvvm

import android.databinding.ViewDataBinding
import android.os.Bundle
import ru.bagrusss.clean_mvvm.BR

abstract class DefaultMvvmActivity<out D, DB : ViewDataBinding, VM : DefaultViewModel> : MvvmActivity<DB, VM, LifecycleHandler<VM>>() {

    protected val data by lazy { provideData() }

    override fun provideLifecycleHandler() = LifecycleHandler(viewModel)

    abstract fun provideData(): D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.setVariable(BR.data, data)
    }

}