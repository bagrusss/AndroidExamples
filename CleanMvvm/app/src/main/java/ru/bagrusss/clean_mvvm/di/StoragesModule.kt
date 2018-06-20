package ru.bagrusss.clean_mvvm.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration
import ru.bagrusss.clean_mvvm.storage.UserStorage
import ru.bagrusss.clean_mvvm.storage.UserStorageRealmImpl
import java.io.File
import javax.inject.Singleton

/**
 * Created by bagrusss on 20.06.18
 */
@Module
class StoragesModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideUserStorage(): UserStorage {
        val filePath = "${context.filesDir}${File.separator}realm${File.separator}user.db"
        val realmConfig = RealmConfiguration.Builder()
                                            .directory(File(filePath))
                                            .build()
        return UserStorageRealmImpl(realmConfig)
    }


}