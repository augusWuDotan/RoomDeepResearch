package com.augus.roomdeepresearch.Database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import com.augus.roomdeepresearch.Database.IItemLayoutRes
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = DatabaseConstants.ADDRESS_BOOK_TABLE_NAME,
    primaryKeys = [DatabaseConstants.ID, DatabaseConstants.OWNER]
)
data class AddressBook(
    @SerializedName("id")
    @ColumnInfo(name = DatabaseConstants.ID)
    val id: Int,

    @SerializedName("conversationID")
    @ColumnInfo(name = DatabaseConstants.CONVERSATION_ID)
    val conversationID: String?,

    @SerializedName("nickname")
    @ColumnInfo(name = DatabaseConstants.NICKNAME)
    val nickname: String?,

    @SerializedName("avatar")
    @Embedded
    val avatar: Avatar?,

    @SerializedName("appID")
    @ColumnInfo(name = DatabaseConstants.APP_ID)
    val appID: String?,

    @SerializedName("gender")
    @ColumnInfo(name = DatabaseConstants.GENDER)
    val gender: String?,

    @SerializedName("relation")
    @ColumnInfo(name = DatabaseConstants.RELATION)
    val relation: Int,

    @SerializedName("notice")
    @ColumnInfo(name = DatabaseConstants.NOTICE)
    val notice: Boolean,

    @SerializedName("owner")
    @ColumnInfo(name = DatabaseConstants.OWNER)
    val owner: Int,

    /**
     * todo  需額外建立 聊天室列表資料表 chat_room_list 結構
     */
    @SerializedName("sticky")
    @Ignore
    val sticky: Boolean
) : IItemLayoutRes, Parcelable {
    override val layoutRes: Int
        get() = 1

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Avatar::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(conversationID)
        parcel.writeString(nickname)
        parcel.writeParcelable(avatar, flags)
        parcel.writeString(appID)
        parcel.writeString(gender)
        parcel.writeInt(relation)
        parcel.writeByte(if (notice) 1 else 0)
        parcel.writeInt(owner)
        parcel.writeByte(if (sticky) 1 else 0)
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