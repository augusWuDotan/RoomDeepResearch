package com.augus.roomdeepresearch.database.model.addressModel

import com.augus.roomdeepresearch.base.IBaseModelListener
import com.augus.roomdeepresearch.database.bean.AddressBook

interface IAddressBookModel {

    fun inserAddressBooks(addressBooks: MutableList<AddressBook>)
    fun inserVarargAddressBooks(vararg addressBooks: AddressBook)
    fun inserAddressBook(addressBook: AddressBook)
    fun getAddressBooks()

    interface IAddressBookModelListener:IBaseModelListener{
        fun inserAddressBooksSuccess(insertResults: MutableList<Long>?)
        fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?)
    }
}