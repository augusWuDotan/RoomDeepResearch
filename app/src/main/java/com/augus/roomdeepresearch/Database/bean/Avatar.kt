package com.augus.roomdeepresearch.Database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.google.gson.annotations.SerializedName

data class Avatar(
    @SerializedName("token")
    @ColumnInfo(name = DatabaseConstants.AVATAR_TOKEN)
    val token: String?,
    @SerializedName("url")
    @ColumnInfo(name = DatabaseConstants.AVATAR_URL)
    val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(token)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Avatar> {
        override fun createFromParcel(parcel: Parcel): Avatar {
            return Avatar(parcel)
        }

        override fun newArray(size: Int): Array<Avatar?> {
            return arrayOfNulls(size)
        }
    }
}