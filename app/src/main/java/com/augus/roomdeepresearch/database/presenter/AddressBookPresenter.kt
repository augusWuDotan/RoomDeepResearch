package com.augus.roomdeepresearch.database.presenter

import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.model.addressModel.AddressBookModel
import com.augus.roomdeepresearch.database.model.addressModel.IAddressBookModel

class AddressBookPresenter(var addressBookView: IAddressBookContract.IAddressBookView?) :
    IAddressBookContract.IAddressBookPresenter {

    private val addressBookModelListener = object : IAddressBookModel.IAddressBookModelListener {
        override fun inserAddressBooksSuccess(insertResults: MutableList<Long>?) {
            addressBookView?.inserAddressBooksSuccess(insertResults)
        }

        override fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?) {
            addressBookView?.getAddressBooksSuccess(addressBooks)
        }

        override fun onStart() {
            addressBookView?.showLoading()
        }

        override fun complete() {
            addressBookView?.hideLoading()
        }

        override fun showError(errorMsg: String?) {
            addressBookView?.showError(errorMsg)
        }
    }

    var addressBookModel: AddressBookModel? = AddressBookModel(addressBookModelListener)


    override fun unsubscribe() {
        addressBookModel?.unsubscribe()
        addressBookModel = null
        addressBookView = null
    }

    override fun inserAddressBooks(addressBooks: MutableList<AddressBook>) {
        addressBookModel?.inserAddressBooks(addressBooks)
    }

    override fun inserVarargAddressBooks(vararg addressBooks: AddressBook) {
        addressBookModel?.inserVarargAddressBooks(*addressBooks)
    }

    override fun inserAddressBook(addressBook: AddressBook) {
        addressBookModel?.inserAddressBook(addressBook)
    }

    override fun getAddressBooks() {
        addressBookModel?.getAddressBooks()
    }
}