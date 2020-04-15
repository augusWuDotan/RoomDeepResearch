package com.augus.roomdeepresearch.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DisposableManager {

    companion object {
        val instance: DisposableManager = DisposableManagerHolder.disposableManagerHolder()
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private object DisposableManagerHolder {
        fun disposableManagerHolder(): DisposableManager {
            return DisposableManager()
        }
    }

    fun addAll(vararg ds: Disposable) {
        compositeDisposable.addAll(*ds)
    }

    fun add(ds: Disposable) {
        compositeDisposable.add(ds)
    }

    fun clear() {
        compositeDisposable.clear()
    }

    fun dispose() {
        compositeDisposable.dispose()
    }

    fun isDispose(): Boolean {
        return compositeDisposable.isDisposed
    }

    fun size(): Int {
        return compositeDisposable.size()
    }

    fun delete(ds: Disposable) {
        compositeDisposable.delete(ds)
    }

    fun delete(dss: MutableList<Disposable>) {
        dss.forEach {
            compositeDisposable.delete(it)
        }
    }

}