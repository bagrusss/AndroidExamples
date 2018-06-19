package ru.bagrusss.clean_mvvm.rx

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Created by bagrusss on 19.06.18
 */


abstract class ObservableInteractor<P, R>(private val subscribeScheduler: Scheduler,
                                          private val observeScheduler: Scheduler) {

    fun interact(params: P): Observable<R> = buildPublisher(params).subscribeOn(subscribeScheduler)
                                                                   .observeOn(observeScheduler)

    protected abstract fun buildPublisher(params: P): Observable<R>
}

abstract class EmptyObservableInteractor<R>(subscribeScheduler: Scheduler,
                                            observeScheduler: Scheduler) : ObservableInteractor<Unit, R>(subscribeScheduler, observeScheduler) {

    fun interact() = super.interact(Unit)
}

abstract class SingleInteractor<P, R>(private val subscribeScheduler: Scheduler,
                                      private val observeScheduler: Scheduler) {

    fun interact(params: P): Single<R> = buildPublisher(params).subscribeOn(subscribeScheduler)
                                                               .observeOn(observeScheduler)

    protected abstract fun buildPublisher(params: P): Single<R>
}

abstract class EmptySingleInteractor<R>(subscribeScheduler: Scheduler,
                                        observeScheduler: Scheduler) : SingleInteractor<Unit, R>(subscribeScheduler, observeScheduler) {

    fun interact() = super.interact(Unit)
}

abstract class CompletableInteractor<P>(private val subscribeScheduler: Scheduler,
                                        private val observeScheduler: Scheduler) {

    fun interact(params: P): Completable = buildPublisher(params).subscribeOn(subscribeScheduler)
                                                                 .observeOn(observeScheduler)

    protected abstract fun buildPublisher(params: P): Completable


}

abstract class EmptyCompletableInteractor<R>(subscribeScheduler: Scheduler,
                                             observeScheduler: Scheduler) : CompletableInteractor<Unit>(subscribeScheduler, observeScheduler) {

    fun interact() = super.interact(Unit)
}