package ru.bagrusss.clean_mvvm.rx

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by bagrusss on 19.06.18
 */

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

fun completable(func: () -> Unit): Completable = Completable.create {
    func()
    it.onComplete()
}

fun <R> single(func: () -> R): Single<R> = Single.create<R> {
    val result = func()
    it.onSuccess(result)
}