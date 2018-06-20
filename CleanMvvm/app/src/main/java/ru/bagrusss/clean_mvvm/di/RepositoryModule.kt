package ru.bagrusss.clean_mvvm.di

import dagger.Module
import dagger.Provides
import ru.bagrusss.clean_mvvm.network.NetworkSender
import ru.bagrusss.clean_mvvm.repository.DemoRepository
import ru.bagrusss.clean_mvvm.repository.DemoRepositoryImpl
import ru.bagrusss.clean_mvvm.storage.UserStorage
import javax.inject.Singleton

/**
 * Created by bagrusss on 20.06.2018
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDemoRepository(userStorage: UserStorage, networkSender: NetworkSender): DemoRepository {
        return DemoRepositoryImpl(userStorage, networkSender)
    }

}