package com.augus.roomdeepresearch.Database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.augus.roomdeepresearch.Database.bean.AddressBook
import com.augus.roomdeepresearch.Database.bean.Group
import com.augus.roomdeepresearch.Database.bean.NewFriend
import com.augus.roomdeepresearch.base.BaseApplication
import com.augus.roomdeepresearch.base.DatabaseConstants

@Database(
    entities = [AddressBook::class, NewFriend::class, Group::class],
    version = 1
)
abstract class TFDatabase : RoomDatabase() {

    companion object {
        val instance = TFDatabaseHolder.getDatabase()
    }

    object TFDatabaseHolder {
        fun getDatabase(): TFDatabase {
            return Room.databaseBuilder(
                    BaseApplication.context(),
                    TFDatabase::class.java,
                    DatabaseConstants.SQL_NAME
                )
                .build()
        }


    }
}