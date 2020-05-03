package com.augus.roomdeepresearch.database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.google.gson.annotations.SerializedName

@Entity(
    primaryKeys = [DatabaseConstants.CONVERSATION_ID, DatabaseConstants.OWNER],
    tableName = DatabaseConstants.CHAT_ROOM_LIST_TABLE_NAME
)
data class ChatListRoomBean(

    @SerializedName(DatabaseConstants.CONVERSATION_ID)
    @ColumnInfo(name = DatabaseConstants.CONVERSATION_ID)
    var conversationID: String = "",

    @SerializedName("owner")
    @ColumnInfo(name = DatabaseConstants.OWNER)
    var owner: Long = 0L

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(conversationID)
        parcel.writeLong(owner)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChatListRoomBean> {
        override fun createFromParcel(parcel: Parcel): ChatListRoomBean {
            return ChatListRoomBean(parcel)
        }

        override fun newArray(size: Int): Array<ChatListRoomBean?> {
            return arrayOfNulls(size)
        }
    }
}
