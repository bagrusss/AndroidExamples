package ru.bagrusss.clean_mvvm.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.bagrusss.clean_mvvm.app.DemoApp
import ru.bagrusss.clean_mvvm.screens.main.MainVM
import javax.inject.Singleton

/**
 * Created by bagrusss on 19.06.18
 */
@Singleton
@Component(modules = [
    ActivityBindModule::class,
    FragmentBindModule::class,

    NetworkModule::class,
    StoragesModule::class,
    InteractorsModule::class,
    RepositoryModule::class,


    AndroidSupportInjectionModule::class])

interface AppComponent : AndroidInjector<DemoApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(viewModel: MainVM)
}