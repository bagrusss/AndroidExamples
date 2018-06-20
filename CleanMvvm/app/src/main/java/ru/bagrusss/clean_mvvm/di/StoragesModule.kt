package ru.bagrusss.clean_mvvm.di

import dagger.Module
import dagger.Provides
import ru.bagrusss.clean_mvvm.storage.UserStorage
import ru.bagrusss.clean_mvvm.storage.UserStorageImpl
import javax.inject.Singleton

/**
 * Created by bagrusss on 20.06.18
 */
@Module
class StoragesModule {

    @Provides
    @Singleton
    fun provideUserStorage(): UserStorage = UserStorageImpl()


}