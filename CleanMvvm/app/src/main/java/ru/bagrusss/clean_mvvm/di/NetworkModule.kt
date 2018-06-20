package ru.bagrusss.clean_mvvm.di

import dagger.Module
import dagger.Provides
import ru.bagrusss.clean_mvvm.network.NetworkSender
import ru.bagrusss.clean_mvvm.network.NetworkSenderImpl
import ru.bagrusss.clean_mvvm.network.api.UserApi
import ru.bagrusss.clean_mvvm.network.api.UserApiFakeImpl
import ru.bagrusss.clean_mvvm.network.error.ErrorHandler
import ru.bagrusss.clean_mvvm.network.error.ErrorHandlerImpl
import ru.bagrusss.clean_mvvm.storage.UserStorage
import javax.inject.Singleton

/**
 * Created by bagrusss on 20.06.18
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkSender(userApi: UserApi, errorHandler: ErrorHandler): NetworkSender {
        return NetworkSenderImpl(userApi, errorHandler)
    }

    @Provides
    @Singleton
    fun provideErrorHandler(userStorage: UserStorage): ErrorHandler = ErrorHandlerImpl(userStorage)

    @Provides
    @Singleton
    fun provideUserApi(): UserApi = UserApiFakeImpl()

}