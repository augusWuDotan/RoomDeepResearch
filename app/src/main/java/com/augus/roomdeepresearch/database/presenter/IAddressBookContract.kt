package com.augus.roomdeepresearch.database.presenter

import com.augus.roomdeepresearch.base.IBasePresenter
import com.augus.roomdeepresearch.base.IBaseView
import com.augus.roomdeepresearch.database.bean.AddressBook

interface IAddressBookContract {

    interface IAddressBookView : IBaseView {
        fun inserAddressBooksSuccess(insertResults: MutableList<Long>?)
        fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?)
    }

    interface IAddressBookPresenter : IBasePresenter {

        fun inserAddressBooks(addressBooks: MutableList<AddressBook>)
        fun inserVarargAddressBooks(vararg addressBooks: AddressBook)
        fun inserAddressBook(addressBook: AddressBook)
        fun getAddressBooks()

    }
}