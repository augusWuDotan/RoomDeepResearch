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

    private fun addAll(vararg ds: Disposable) {
        compositeDisposable.addAll(*ds)
    }

    private fun add(ds: Disposable) {
        compositeDisposable.add(ds)
    }

    private fun clear() {
        compositeDisposable.clear()
    }

    private fun dispose() {
        compositeDisposable.dispose()
    }

    private fun isDispose(): Boolean {
        return compositeDisposable.isDisposed
    }

    private fun size(): Int {
        return compositeDisposable.size()
    }

    private fun delete(ds: Disposable) {
        compositeDisposable.delete(ds)
    }

}