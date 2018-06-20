package ru.bagrusss.clean_mvvm.di

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.bagrusss.clean_mvvm.interactors.DemoInteractor
import ru.bagrusss.clean_mvvm.repository.DemoRepository

/**
 * Created by bagrusss on 20.06.18
 */
@Module
class InteractorsModule {

    @Provides
    fun provideDemoInteractor(demoRepository: DemoRepository): DemoInteractor {
        return DemoInteractor(demoRepository, Schedulers.io(), AndroidSchedulers.mainThread())
    }

}