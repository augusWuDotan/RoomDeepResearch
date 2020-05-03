package com.augus.roomdeepresearch.database

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.augus.roomdeepresearch.base.BaseApplication
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.augus.roomdeepresearch.database.bean.Group
import com.augus.roomdeepresearch.database.bean.NewFriend
import com.augus.roomdeepresearch.database.dao.TestDAO

//
@Database(
    entities = [AddressBook::class, NewFriend::class, Group::class, ChatListRoomBean::class
    ],
    version = 1
)
abstract class TFDatabase : RoomDatabase() {

    abstract val testDao: TestDAO

    companion object {
        val instance = TFDatabaseHolder.getDatabase()
    }

    object TFDatabaseHolder {
        fun getDatabase(): TFDatabase {
            Log.d("TFDatabaseHolder", "getDatabase")
            return Room.databaseBuilder(
                BaseApplication.context(),
                TFDatabase::class.java,
                DatabaseConstants.SQL_NAME
            )
                .build()
        }

    }
}