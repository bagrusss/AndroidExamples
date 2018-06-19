package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class MvvmActivity<DB: ViewDataBinding, VM: ViewModel, LH: LifecycleHandler>: DaggerAppCompatActivity() {

    protected abstract val layoutId: Int
    protected abstract val viewModelClass: Class<VM>

    protected val lifecycleHandler: LH by lazy { provideLifecycleHandler() }

    protected abstract fun provideLifecycleHandler(): LH

    protected lateinit var binding: DB
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        lifecycle.addObserver(lifecycleHandler)
        viewModel = ViewModelProviders.of(this)[viewModelClass]
    }
}