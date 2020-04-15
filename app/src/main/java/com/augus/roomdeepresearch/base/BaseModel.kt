package com.augus.roomdeepresearch.base

import io.reactivex.disposables.Disposable

 abstract class BaseModel {
    val disposableManager = DisposableManager.instance
    fun addDisposable(disposableList: MutableList<Disposable>, disposable: Disposable): Disposable {
        disposableList.add(disposable)
        return disposable
    }

    abstract fun unsubscribe()
}