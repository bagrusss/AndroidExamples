package ru.bagrusss.clean_mvvm.app

import io.realm.Realm
import ru.bagrusss.clean_mvvm.di.AndroidModule
import ru.bagrusss.clean_mvvm.di.DaggerAppComponent
import ru.bagrusss.clean_mvvm.di.StoragesModule

/**
 * Created by bagrusss on 20.06.2018
 */
class DemoApp: DaggerMultidexAppication() {

    val injector = DaggerAppComponent.builder()
                                     .application(this)
                                     .androidModule(AndroidModule(this))
                                     .storagesModule(StoragesModule(this))
                                     .build()

    override fun applicationInjector() = injector

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

}