package ru.bagrusss.clean_mvvm.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.bagrusss.clean_mvvm.provider.ResourceProvider
import ru.bagrusss.clean_mvvm.provider.ResourceProviderImpl
import javax.inject.Singleton

/**
 * Created by bagrusss on 20.06.2018
 */
@Module
class AndroidModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideResourceProvider(): ResourceProvider = ResourceProviderImpl(context)
}