package ru.bagrusss.clean_mvvm.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.bagrusss.clean_mvvm.di.AndroidModule
import ru.bagrusss.clean_mvvm.di.DaggerAppComponent

/**
 * Created by bagrusss on 20.06.2018
 */
class DemoApp: DaggerMultidexAppication() {


    val injector = DaggerAppComponent.builder()
                                     .application(this)
                                     .androidModule(AndroidModule(this))
                                     .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return injector
    }

}