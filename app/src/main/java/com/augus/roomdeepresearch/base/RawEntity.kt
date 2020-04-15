package com.augus.roomdeepresearch.base

import android.content.res.Resources
import com.augus.roomdeepresearch.R
import com.augus.roomdeepresearch.database.bean.AddressBook
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
    }
}