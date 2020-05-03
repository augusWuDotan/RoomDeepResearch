package com.augus.roomdeepresearch.base

import android.content.res.Resources
import com.augus.roomdeepresearch.R
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader

class RawEntity {
    companion object {
        fun initAddressBookEntryList(resources: Resources): MutableList<AddressBook> {
            val inputStream = resources.openRawResource(R.raw.address_book)
            val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
            val gson = Gson()
            val productListType = object : TypeToken<MutableList<AddressBook>>() {}.type
            return gson.fromJson(jsonProductsString, productListType)
        }

        fun initChatListEntryList(resources: Resources): MutableList<ChatListRoomBean> {
            val inputStream = resources.openRawResource(R.raw.chat_list)
            val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
            val gson = Gson()
            val productListType = object : TypeToken<MutableList<ChatListRoomBean>>() {}.type
            return gson.fromJson(jsonProductsString, productListType)
        }
    }
}