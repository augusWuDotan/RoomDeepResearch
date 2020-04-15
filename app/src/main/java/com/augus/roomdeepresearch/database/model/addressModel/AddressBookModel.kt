package com.augus.roomdeepresearch.database.model.addressModel

import android.util.Log
import com.augus.roomdeepresearch.base.BaseModel
import com.augus.roomdeepresearch.database.TFDatabase
import com.augus.roomdeepresearch.database.bean.AddressBook
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

class AddressBookModel(var listener: IAddressBookModel.IAddressBookModelListener?) : BaseModel(), IAddressBookModel {

    private var ds: MutableList<Disposable> = mutableListOf()

    override fun unsubscribe() {
        if (ds.size > 0) disposableManager.delete(ds)
        listener = null
    }

    override fun inserAddressBooks(addressBooks: MutableList<AddressBook>) {
        disposableManager.add(
            addDisposable(
                ds,
                TFDatabase.instance.addressBook.insertAddressBooks(addressBooks)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(
                        object : DisposableMaybeObserver<MutableList<Long>>() {
                            override fun onStart() {
                                super.onStart()
                                listener?.onStart()
                            }

                            override fun onSuccess(t: MutableList<Long>) {
                                listener?.inserAddressBooksSuccess(t)
                            }

                            override fun onComplete() {
                                listener?.complete()
                            }

                            override fun onError(e: Throwable) {
                                e.stackTrace.forEach {
                                    Log.d("stackTrace","className:${it.className} \nmethodName:${it.methodName}  \nlineNumber:${it.lineNumber}")
                                }
                                listener?.showError(e.message)
                            }
                        }
                    )
            )
        )
    }

    override fun inserVarargAddressBooks(vararg addressBooks: AddressBook) {

    }

    override fun inserAddressBook(addressBook: AddressBook) {

    }

    override fun getAddressBooks() {
        disposableManager.add(
            addDisposable(
                ds,
                TFDatabase.instance.addressBook.getAddressBooks()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : ResourceSubscriber<MutableList<AddressBook>>() {
                        override fun onStart() {
                            super.onStart()
                            listener?.onStart()
                        }

                        override fun onComplete() {
                            listener?.complete()
                        }

                        override fun onNext(t: MutableList<AddressBook>?) {
                            listener?.getAddressBooksSuccess(t)
                        }

                        override fun onError(t: Throwable?) {
                            listener?.showError(t?.message)
                        }
                    })
            )
        )
    }
}


