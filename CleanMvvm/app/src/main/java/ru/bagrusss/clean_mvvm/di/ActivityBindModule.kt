package ru.bagrusss.clean_mvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.bagrusss.clean_mvvm.screens.main.MainActivity

/**
 * Created by bagrusss on 19.06.18
 */
@Module
interface ActivityBindModule {

    @ContributesAndroidInjector
    fun bindMainActitivy(): MainActivity
}