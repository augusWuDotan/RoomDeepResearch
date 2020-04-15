package com.augus.roomdeepresearch.database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.augus.roomdeepresearch.database.IItemLayoutRes
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = DatabaseConstants.ADDRESS_BOOK_TABLE_NAME,
    primaryKeys = [DatabaseConstants.ID, DatabaseConstants.OWNER]
)
data class AddressBook(
    @SerializedName("id")
    @ColumnInfo(name = DatabaseConstants.ID)
    var id: Long = 0L,

    @SerializedName("conversationID")
    @ColumnInfo(name = DatabaseConstants.CONVERSATION_ID)
    var conversationID: String? = "",

    @SerializedName("nickname")
    @ColumnInfo(name = DatabaseConstants.NICKNAME)
    var nickname: String?= "",

    @SerializedName("avatar")
    @Embedded
    var avatar: Avatar?=null,

    @SerializedName("appID")
    @ColumnInfo(name = DatabaseConstants.APP_ID)
    var appID: String?= "",

    @SerializedName("gender")
    @ColumnInfo(name = DatabaseConstants.GENDER)
    var gender: String?= "",

    @SerializedName("relation")
    @ColumnInfo(name = DatabaseConstants.RELATION)
    var relation:  Long = 0L,

    @SerializedName("notice")
    @ColumnInfo(name = DatabaseConstants.NOTICE)
    var notice: Boolean = false,

    @SerializedName("owner")
    @ColumnInfo(name = DatabaseConstants.OWNER)
    var owner:  Long = 0L,

//    @SerializedName("test")
//    @ColumnInfo(name = "test")
//    var test:  Boolean = false,

    /**
     * todo  需額外建立 聊天室列表資料表 chat_room_list 結構
     */
    @SerializedName("sticky")
    @Ignore
    var sticky: Boolean = false,

    @Ignore
    override val layoutRes: Int = 0
) : IItemLayoutRes, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Avatar::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readByte() != 0.toByte(),
        parcel.readLong(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(conversationID)
        parcel.writeString(nickname)
        parcel.writeParcelable(avatar, flags)
        parcel.writeString(appID)
        parcel.writeString(gender)
        parcel.writeLong(relation)
        parcel.writeByte(if (notice) 1 else 0)
        parcel.writeLong(owner)
        parcel.writeByte(if (sticky) 1 else 0)
        parcel.writeInt(layoutRes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddressBook> {
        override fun createFromParcel(parcel: Parcel): AddressBook {
            return AddressBook(parcel)
        }

        override fun newArray(size: Int): Array<AddressBook?> {
            return arrayOfNulls(size)
        }
    }
}