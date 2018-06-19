package ru.bagrusss.clean_mvvm.rx

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by bagrusss on 19.06.18
 */

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}