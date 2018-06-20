package ru.bagrusss.clean_mvvm.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.bagrusss.clean_mvvm.app.DemoApp

/**
 * Created by bagrusss on 19.06.18
 */
@Component(modules = [

            AndroidSupportInjectionModule::class])

interface AppComponent: AndroidInjector<DemoApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
}