package com.augus.roomdeepresearch.database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.google.gson.annotations.SerializedName

data class Announcer(

    @SerializedName("avatar")
    @Ignore
    val avatar: Avatar?,

    @SerializedName("id")
    @ColumnInfo(name = DatabaseConstants.ANNOUNCER)
    val id: Long = 0,

    @SerializedName("nickname")
    @Ignore
    val nickname: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Avatar::class.java.classLoader),
        parcel.readLong(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(avatar, flags)
        parcel.writeLong(id)
        parcel.writeString(nickname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Announcer> {
        override fun createFromParcel(parcel: Parcel): Announcer {
            return Announcer(parcel)
        }

        override fun newArray(size: Int): Array<Announcer?> {
            return arrayOfNulls(size)
        }
    }
}