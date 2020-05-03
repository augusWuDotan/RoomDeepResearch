package com.augus.roomdeepresearch.database.bean

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.augus.roomdeepresearch.base.DatabaseConstants

/**
 * @author augus
 * @create 2020-05-03
 * @Describe
 */
data class ChatListWithAddress(
    @Embedded
    var chatListRoomBean: ChatListRoomBean? = null,

    @Relation(
        parentColumn = DatabaseConstants.CONVERSATION_ID,
        entityColumn = DatabaseConstants.CONVERSATION_ID,
        entity = AddressBook::class
    )
    var addressBooks: List<AddressBook>,

    @Relation(
        parentColumn = DatabaseConstants.CONVERSATION_ID,
        entityColumn = DatabaseConstants.CONVERSATION_ID,
        entity = AddressBook::class
    )
    var addressBooks_1: List<AddressBook>

) {
    fun getAddressBook(): AddressBook {
        return addressBooks.filter {
            it.owner == chatListRoomBean?.owner
        }.first()
    }
}