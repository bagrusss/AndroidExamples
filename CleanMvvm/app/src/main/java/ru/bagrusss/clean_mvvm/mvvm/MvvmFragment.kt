package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

/**
 * Created by bagrusss on 29.05.2018
 */
abstract class MvvmFragment<DB : ViewDataBinding, VM : DefaultViewModel, LH : LifecycleHandler<VM>> : DaggerFragment() {

    protected lateinit var binding: DB
    protected val lifecycleHandler by lazy { provideLifecycleHandler() }

    protected abstract fun provideLifecycleHandler(): LH

    protected abstract val layoutId: Int

    protected lateinit var viewModel: VM

    abstract val viewModelClass: Class<VM>

    protected abstract fun observeToLiveData(owner: LifecycleOwner)

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, container, false)
        viewModel = ViewModelProviders.of(this)[viewModelClass]
        lifecycle.addObserver(lifecycleHandler)

        observeToLiveData(this)

        return binding.root
    }

    open fun onBackPressed() = viewModel.onBackPressed()

}