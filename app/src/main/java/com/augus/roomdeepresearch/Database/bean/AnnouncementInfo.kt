package com.augus.roomdeepresearch.Database.bean

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.augus.roomdeepresearch.base.DatabaseConstants
import com.google.gson.annotations.SerializedName

data class AnnouncementInfo(
    @SerializedName("isAnnouncement")
    @ColumnInfo(name = DatabaseConstants.IS_ANNOUNCEMENT)
    val isAnnouncement: Boolean = false,

    @SerializedName("announcement")
    @ColumnInfo(name = DatabaseConstants.ANNOUNCEMENT)
    val announcement: String?,

    @SerializedName("announcer")
    @Embedded
    val announcer: Announcer?,

    @SerializedName("announceAt")
    @ColumnInfo(name = DatabaseConstants.ANNOUNCE_AT)
    val announceAt: Long = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readParcelable(Announcer::class.java.classLoader),
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (isAnnouncement) 1 else 0)
        parcel.writeString(announcement)
        parcel.writeParcelable(announcer, flags)
        parcel.writeLong(announceAt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AnnouncementInfo> {
        override fun createFromParcel(parcel: Parcel): AnnouncementInfo {
            return AnnouncementInfo(parcel)
        }

        override fun newArray(size: Int): Array<AnnouncementInfo?> {
            return arrayOfNulls(size)
        }
    }
}