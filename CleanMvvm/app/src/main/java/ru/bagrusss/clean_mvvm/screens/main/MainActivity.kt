package ru.bagrusss.clean_mvvm.screens.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.bagrusss.clean_mvvm.R
import ru.bagrusss.clean_mvvm.databinding.ActivityMainBinding
import ru.bagrusss.clean_mvvm.mvvm.DefaultMvvmActivity

class MainActivity : DefaultMvvmActivity<ActivityMainBinding, MainVM>() {

    override val layoutId = R.layout.activity_main
    override val viewModelClass = MainVM::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        injector.inject(viewModel)
    }

    override fun observeToLiveData(owner: AppCompatActivity) {
        viewModel.run {

        }
    }
}
