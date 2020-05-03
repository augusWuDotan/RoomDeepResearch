package com.augus.roomdeepresearch.database.presenter

import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.augus.roomdeepresearch.database.bean.ChatListWithAddress
import com.augus.roomdeepresearch.database.model.addressModel.TestModel
import com.augus.roomdeepresearch.database.model.addressModel.ITestModel

class TestPresenter(var testView: ITestContract.ITestView?) :
    ITestContract.ITestPresenter {

    private val testModelListener = object : ITestModel.ITestModelListener {
        override fun inserAddressBooksSuccess(insertResults: MutableList<Long>?) {
            testView?.inserAddressBooksSuccess(insertResults)
        }

        override fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?) {
            testView?.getAddressBooksSuccess(addressBooks)
        }

        override fun onStart() {
            testView?.showLoading()
        }

        override fun complete() {
            testView?.hideLoading()
        }

        override fun showError(errorMsg: String?) {
            testView?.showError(errorMsg)
        }

        override fun inserChatListsSuccess(insertResults: MutableList<Long>?) {
            testView?.inserChatListsSuccess(insertResults)
        }

        override fun getChatListsSuccess(chatLists: MutableList<ChatListRoomBean>?) {
            testView?.getChatListsSuccess(chatLists)
        }

        override fun getChatListWithAddressBooksSuccess(chatListWithAddress: MutableList<ChatListWithAddress>?) {
            testView?.getChatListWithAddressBooksSuccess(chatListWithAddress)
        }
    }

    var testModel: TestModel? = TestModel(testModelListener)


    override fun unsubscribe() {
        testModel?.unsubscribe()
        testModel = null
        testView = null
    }

    override fun inserAddressBooks(addressBooks: MutableList<AddressBook>) {
        testModel?.inserAddressBooks(addressBooks)
    }

    override fun inserVarargAddressBooks(vararg addressBooks: AddressBook) {
        testModel?.inserVarargAddressBooks(*addressBooks)
    }

    override fun inserAddressBook(addressBook: AddressBook) {
        testModel?.inserAddressBook(addressBook)
    }

    override fun getAddressBooks() {
        testModel?.getAddressBooks()
    }

    override fun inserChatLists(chatLists: MutableList<ChatListRoomBean>) {
        testModel?.inserChatLists(chatLists)
    }

    override fun getChatLists() {
        testModel?.getChatLists()
    }

    override fun getChatListWithAddressBooks() {
        testModel?.getChatListWithAddressBooks()
    }
}