package com.augus.roomdeepresearch.database.presenter

import com.augus.roomdeepresearch.base.IBasePresenter
import com.augus.roomdeepresearch.base.IBaseView
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.augus.roomdeepresearch.database.bean.ChatListWithAddress

interface ITestContract {

    interface ITestView : IBaseView {
        fun inserAddressBooksSuccess(insertResults: MutableList<Long>?)
        fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?)
        fun inserChatListsSuccess(insertResults: MutableList<Long>?)
        fun getChatListsSuccess(chatLists: MutableList<ChatListRoomBean>?)
        fun getChatListWithAddressBooksSuccess(chatLists: MutableList<ChatListWithAddress>?)
    }

    interface ITestPresenter : IBasePresenter {

        fun inserAddressBooks(addressBooks: MutableList<AddressBook>)
        fun inserVarargAddressBooks(vararg addressBooks: AddressBook)
        fun inserAddressBook(addressBook: AddressBook)
        fun getAddressBooks()
        fun inserChatLists(addressBooks: MutableList<ChatListRoomBean>)
        fun getChatLists()
        fun getChatListWithAddressBooks()

    }
}