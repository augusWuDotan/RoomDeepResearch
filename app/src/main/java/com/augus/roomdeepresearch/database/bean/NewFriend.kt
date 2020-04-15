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
    tableName = DatabaseConstants.NEW_FRIEND_TABLE_NAME,
    primaryKeys = [DatabaseConstants.ID, DatabaseConstants.OWNER]
)
data class NewFriend(
    @SerializedName("id")
    @ColumnInfo(name = DatabaseConstants.ID)
    var id: Long = 0L,

    @SerializedName("nickname")
    @ColumnInfo(name = DatabaseConstants.NICKNAME)
    var nickname: String? = "",

    @SerializedName("avatar")
    @Embedded
    var avatar: Avatar? = null,

    @SerializedName("introduction")
    @ColumnInfo(name = DatabaseConstants.INTRODUCTION)
    var introduction: String? = "",

    @SerializedName("isRead")
    @ColumnInfo(name = DatabaseConstants.IS_READ)
    var isRead: Boolean = false,

    @SerializedName("createAt")
    @ColumnInfo(name = DatabaseConstants.CREATE_AT)
    var createAt: String? = "",

    @SerializedName("gender")
    @ColumnInfo(name = DatabaseConstants.GENDER)
    var gender: String? = "",

    @SerializedName("owner")
    @ColumnInfo(name = DatabaseConstants.OWNER)
    var owner: Long = 0L,

    @Ignore
    override val layoutRes: Int = 0
) : IItemLayoutRes, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readParcelable(Avatar::class.java.classLoader),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(nickname)
        parcel.writeParcelable(avatar, flags)
        parcel.writeString(introduction)
        parcel.writeByte(if (isRead) 1 else 0)
        parcel.writeString(createAt)
        parcel.writeString(gender)
        parcel.writeLong(owner)
        parcel.writeInt(layoutRes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewFriend> {
        override fun createFromParcel(parcel: Parcel): NewFriend {
            return NewFriend(parcel)
        }

        override fun newArray(size: Int): Array<NewFriend?> {
            return arrayOfNulls(size)
        }
    }
}