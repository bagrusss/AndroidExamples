package ru.bagrusss.clean_mvvm.screens.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ru.bagrusss.clean_mvvm.R
import ru.bagrusss.clean_mvvm.databinding.ActivityMainBinding
import ru.bagrusss.clean_mvvm.mvvm.DefaultMvvmActivity

class MainActivity : DefaultMvvmActivity<MainData, ActivityMainBinding, MainVM>() {

    override val layoutId = R.layout.activity_main
    override val viewModelClass = MainVM::class.java

    override fun provideData() = MainData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(viewModel)
    }

    override fun observeToLiveData(owner: AppCompatActivity) {
        viewModel.run {
            newTextEvent.observe(owner, Observer {
                data.helloText.set(it)
            })
            textUpdateEvent.observe(owner, Observer {
                Toast.makeText(owner, it!!, Toast.LENGTH_LONG)
                     .show()
            })
            progressEvent.observe(owner, Observer {
                data.progressVisible.set(it!!)
            })
        }
    }
}
