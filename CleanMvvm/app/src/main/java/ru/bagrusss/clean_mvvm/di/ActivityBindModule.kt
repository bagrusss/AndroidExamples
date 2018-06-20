package ru.bagrusss.clean_mvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.bagrusss.clean_mvvm.screens.main.MainActivity

/**
 * Created by bagrusss on 19.06.18
 */
@Module
abstract class ActivityBindModule {

    @ContributesAndroidInjector
    abstract fun bindMainActitivy(): MainActivity
}