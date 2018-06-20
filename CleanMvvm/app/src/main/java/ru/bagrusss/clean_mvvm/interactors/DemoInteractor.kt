package ru.bagrusss.clean_mvvm.interactors

import io.reactivex.Scheduler
import io.reactivex.Single
import ru.bagrusss.clean_mvvm.repository.DemoRepository
import ru.bagrusss.clean_mvvm.rx.EmptySingleInteractor

/**
 * Created by bagrusss on 19.06.18
 */
class DemoInteractor(private val demoRepository: DemoRepository,
                     subscribeScheduler: Scheduler,
                     observeScheduler: Scheduler): EmptySingleInteractor<String>(subscribeScheduler, observeScheduler) {


    override fun buildPublisher(params: Unit): Single<String> {
        return demoRepository.getServerText()
                             .map { "$it some conversion" }
    }

}