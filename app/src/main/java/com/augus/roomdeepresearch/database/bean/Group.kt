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
    tableName = DatabaseConstants.GROUP_TABLE_NAME,
    primaryKeys = [DatabaseConstants.CONVERSATION_ID, DatabaseConstants.OWNER]
)
data class Group(
    @SerializedName("conversationID")
    @ColumnInfo(name = DatabaseConstants.CONVERSATION_ID)
    var conversationID: String = "",

    @SerializedName("name")
    @ColumnInfo(name = DatabaseConstants.NAME)
    var name: String? = "",

    @SerializedName("avatar")
    @Embedded
    var avatar: Avatar? = null,

    @SerializedName("announcementInfo")
    @Embedded
    var announcementInfo: AnnouncementInfo? = null,

    @SerializedName("display")
    @ColumnInfo(name = DatabaseConstants.DISPLAY)
    var display: Boolean = false,

    @SerializedName("notice")
    @ColumnInfo(name = DatabaseConstants.NOTICE)
    var notice: Boolean = false,

    @SerializedName("forbid_speak")
    @ColumnInfo(name = DatabaseConstants.FORBID_SPEAK)
    var forbidSpeak: Boolean = false,

    @SerializedName("role")
    @ColumnInfo(name = DatabaseConstants.ROLE)
    var role: String? = "",

    @SerializedName("status")
    @ColumnInfo(name = DatabaseConstants.STATUS)
    var status: Boolean = true,

    @SerializedName("owner")
    @ColumnInfo(name = DatabaseConstants.OWNER)
    var owner: Long = 0,

    /**
     * todo  需額外建立 聊天室列表資料表 chat_room_list 結構
     */
    @SerializedName("sticky")
    @Ignore
    var sticky: Boolean = false,

    @Ignore
    override var layoutRes: Int = 0
) : IItemLayoutRes, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readParcelable(Avatar::class.java.classLoader),
        parcel.readParcelable(AnnouncementInfo::class.java.classLoader),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readLong(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(conversationID)
        parcel.writeString(name)
        parcel.writeParcelable(avatar, flags)
        parcel.writeParcelable(announcementInfo, flags)
        parcel.writeByte(if (display) 1 else 0)
        parcel.writeByte(if (notice) 1 else 0)
        parcel.writeByte(if (forbidSpeak) 1 else 0)
        parcel.writeString(role)
        parcel.writeByte(if (status) 1 else 0)
        parcel.writeLong(owner)
        parcel.writeByte(if (sticky) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Group> {
        override fun createFromParcel(parcel: Parcel): Group {
            return Group(parcel)
        }

        override fun newArray(size: Int): Array<Group?> {
            return arrayOfNulls(size)
        }
    }
}