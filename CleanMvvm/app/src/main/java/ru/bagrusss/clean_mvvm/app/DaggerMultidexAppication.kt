package ru.bagrusss.clean_mvvm.app

import android.content.Context
import dagger.android.support.DaggerApplication
import android.support.multidex.MultiDex


abstract class DaggerMultidexAppication: DaggerApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}