package ru.bagrusss.clean_mvvm.mvvm

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.bagrusss.clean_mvvm.app.DemoApp
import ru.bagrusss.clean_mvvm.di.AppComponent

/**
 * Created by bagrusss on 05.06.2018
 */
abstract class MvvmDialogFragment<VM: DefaultViewModel, LH: LifecycleHandler<VM>, DB: ViewDataBinding>: DialogFragment() {

    protected lateinit var binding: DB
    protected val lifecycleHandler by lazy { provideLifecycleHandler() }

    protected abstract fun provideLifecycleHandler(): LH

    protected abstract val layoutId: Int

    protected lateinit var viewModel: VM

    abstract val viewModelClass: Class<VM>

    val injector: AppComponent
        get() = (context!!.applicationContext as DemoApp).injector

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, container, false)
        viewModel = ViewModelProviders.of(this)[viewModelClass]
        lifecycle.addObserver(lifecycleHandler)

        observeToLiveData(this)

        return binding.root
    }

    protected abstract fun observeToLiveData(owner: LifecycleOwner)

    open fun onBackPressed() = viewModel.onBackPressed()

}