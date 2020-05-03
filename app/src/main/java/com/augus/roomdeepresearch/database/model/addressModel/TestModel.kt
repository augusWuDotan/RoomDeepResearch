package com.augus.roomdeepresearch.database.model.addressModel

import android.util.Log
import com.augus.roomdeepresearch.base.BaseModel
import com.augus.roomdeepresearch.database.TFDatabase
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.augus.roomdeepresearch.database.bean.ChatListWithAddress
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

class TestModel(var listener: ITestModel.ITestModelListener?) : BaseModel(), ITestModel {

    private var ds: MutableList<Disposable> = mutableListOf()

    override fun unsubscribe() {
        if (ds.size > 0) disposableManager.delete(ds)
        listener = null
    }

    override fun inserAddressBooks(addressBooks: MutableList<AddressBook>) {
        disposableManager.add(
            addDisposable(
                ds,
                TFDatabase.instance.testDao.insertAddressBooks(addressBooks)
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
                                    Log.d("stackTrace","className:${it.className} methodName:${it.methodName}  lineNumber:${it.lineNumber}")
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
                TFDatabase.instance.testDao.getAddressBooks()
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

    override fun inserChatLists(chatLists: MutableList<ChatListRoomBean>) {
        disposableManager.add(
            addDisposable(
                ds,
                TFDatabase.instance.testDao.insertChatLists(chatLists)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(
                        object : DisposableMaybeObserver<MutableList<Long>>() {
                            override fun onStart() {
                                super.onStart()
                                listener?.onStart()
                            }

                            override fun onSuccess(t: MutableList<Long>) {
                                listener?.inserChatListsSuccess(t)
                            }

                            override fun onComplete() {
                                listener?.complete()
                            }

                            override fun onError(e: Throwable) {
                                e.stackTrace.forEach {
                                    Log.d("stackTrace","className:${it.className} methodName:${it.methodName}  lineNumber:${it.lineNumber}")
                                }
                                listener?.showError(e.message)
                            }
                        }
                    )
            )
        )
    }

    override fun getChatLists() {
        disposableManager.add(
            addDisposable(
                ds,
                TFDatabase.instance.testDao.getChatLists()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : ResourceSubscriber<MutableList<ChatListRoomBean>>() {
                        override fun onStart() {
                            super.onStart()
                            listener?.onStart()
                        }

                        override fun onComplete() {
                            listener?.complete()
                        }

                        override fun onNext(t: MutableList<ChatListRoomBean>?) {
                            listener?.getChatListsSuccess(t)
                        }

                        override fun onError(t: Throwable?) {
                            listener?.showError(t?.message)
                        }
                    })
            )
        )
    }

    override fun getChatListWithAddressBooks() {
        disposableManager.add(
            addDisposable(
                ds,
                TFDatabase.instance.testDao.getChatListWithAddressLists()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : ResourceSubscriber<MutableList<ChatListWithAddress>>() {
                        override fun onStart() {
                            super.onStart()
                            listener?.onStart()
                        }

                        override fun onComplete() {
                            listener?.complete()
                        }

                        override fun onNext(t: MutableList<ChatListWithAddress>?) {
                            listener?.getChatListWithAddressBooksSuccess(t)
                        }

                        override fun onError(t: Throwable?) {
                            listener?.showError(t?.message)
                        }
                    })
            )
        )
    }
}


