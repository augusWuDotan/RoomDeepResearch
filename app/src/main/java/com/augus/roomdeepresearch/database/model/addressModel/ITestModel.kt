package com.augus.roomdeepresearch.database.model.addressModel

import com.augus.roomdeepresearch.base.IBaseModelListener
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.augus.roomdeepresearch.database.bean.ChatListWithAddress

interface ITestModel {

    fun inserAddressBooks(addressBooks: MutableList<AddressBook>)
    fun inserVarargAddressBooks(vararg addressBooks: AddressBook)
    fun inserAddressBook(addressBook: AddressBook)
    fun inserChatLists(addressBooks: MutableList<ChatListRoomBean>)
    fun getAddressBooks()
    fun getChatLists()
    fun getChatListWithAddressBooks()

    interface ITestModelListener:IBaseModelListener{
        fun inserAddressBooksSuccess(insertResults: MutableList<Long>?)
        fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?)

        fun inserChatListsSuccess(insertResults: MutableList<Long>?)
        fun getChatListsSuccess(chatLists: MutableList<ChatListRoomBean>?)

        fun getChatListWithAddressBooksSuccess(chatLists: MutableList<ChatListWithAddress>?)
    }
}