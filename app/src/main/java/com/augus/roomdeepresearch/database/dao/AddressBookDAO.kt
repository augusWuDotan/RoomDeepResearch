package com.augus.roomdeepresearch.database.dao

import androidx.room.*
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.augus.roomdeepresearch.database.bean.AddressBook
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface AddressBookDAO {

    @Insert
    fun insertAddressBook(addressBook: AddressBook)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddressBooks(vararg addressBook: AddressBook): Maybe<MutableList<Long>>

    //both 無法回傳
    @Insert
    fun insertBothAddressBooks(
        addressBook1: AddressBook,
        addressBook2: AddressBook
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddressBooks(addressBooks: MutableList<AddressBook>): Maybe<MutableList<Long>>

    @Update
    fun updateAddressBook(addressBook: AddressBook): Single<Int>

    @Update
    fun updateAddressBooks(vararg addressBook: AddressBook): Single<Int>

    @Update
    fun updateAddressBooks(addressBooks: MutableList<AddressBook>): Single<Int>

    @Delete
    fun deleteAddressBooks(vararg addressBook: AddressBook): Single<Int>

    @Query("SELECT * FROM ${DatabaseConstants.ADDRESS_BOOK_TABLE_NAME}")
    fun getAddressBooks(): Flowable<MutableList<AddressBook>>

    @Query("SELECT * FROM ${DatabaseConstants.ADDRESS_BOOK_TABLE_NAME}")
    fun getAddressBooksSortWithRomanPinyin(): Flowable<MutableList<AddressBook>>
}