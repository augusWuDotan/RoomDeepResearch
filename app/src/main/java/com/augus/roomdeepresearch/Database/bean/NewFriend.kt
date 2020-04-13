package com.augus.roomdeepresearch.Database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.augus.roomdeepresearch.Database.IItemLayoutRes
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.google.gson.annotations.SerializedName

data class NewFriend(
    @SerializedName("id")
    @ColumnInfo(name = DatabaseConstants.ID)
    val id: Int,

    @SerializedName("nickname")
    @ColumnInfo(name = DatabaseConstants.NICKNAME)
    val nickname: String?,

    @SerializedName("avatar")
    @Embedded
    val avatar: Avatar?,

    @SerializedName("introduction")
    @ColumnInfo(name = DatabaseConstants.INTRODUCTION)
    val introduction: String?,

    @SerializedName("isRead")
    @ColumnInfo(name = DatabaseConstants.IS_READ)
    val isRead: Boolean,

    @SerializedName("createAt")
    @ColumnInfo(name = DatabaseConstants.CREATE_AT)
    val createAt: String?,

    @SerializedName("gender")
    @ColumnInfo(name = DatabaseConstants.GENDER)
    val gender: String?,

    @SerializedName("owner")
    @ColumnInfo(name = DatabaseConstants.OWNER)
    val owner: Int
) : IItemLayoutRes, Parcelable {
    override val layoutRes: Int
        get() = 1

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(Avatar::class.java.classLoader),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nickname)
        parcel.writeParcelable(avatar, flags)
        parcel.writeString(introduction)
        parcel.writeByte(if (isRead) 1 else 0)
        parcel.writeString(createAt)
        parcel.writeString(gender)
        parcel.writeInt(owner)
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