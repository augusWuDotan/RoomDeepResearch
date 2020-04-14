package com.augus.roomdeepresearch.base

class DatabaseConstants {
    companion object {
        /**
         * 資料庫命名
         */
        const val SQL_NAME = "TfMessage.db"

        /**
         * 資料表命名
         */
        //通訊錄
        const val ADDRESS_BOOK_TABLE_NAME = "address_book"

        //新朋友
        const val NEW_FRIEND_TABLE_NAME = "new_friend"

        //群組
        const val GROUP_TABLE_NAME = "group_list"

        //聊天室
        const val CHAT_ROOM_LIST_TABLE_NAME = "chat_room_list"

        //聊天信息
        const val CHAT_LIST_TABLE_NAME = "chat_list"

        //官方帳號
        const val OFFICIAL_ACCOUNT_TABLE_NAME = "official_account"

        //紅包紀錄
        const val RED_ENVELOPE_RECORD_TABLE_NAME = "red_envelope_record"

        /**
         * 欄位命名
         */
        const val ID = "id"
        const val CONVERSATION_ID = "conversation_id"
        const val NICKNAME = "nickname"
        const val AVATAR_URL = "avatar_url"
        const val AVATAR_TOKEN = "avatar_token"
        const val APP_ID = "app_id"
        const val GENDER = "gender"
        const val RELATION = "relation"
        const val NOTICE = "notice"
        const val OWNER = "owner"
        const val STICKY = "sticky"
        const val INTRODUCTION = "introduction"
        const val IS_READ = "is_read"
        const val CREATE_AT = "create_at"
        const val NAME = "name"
        const val IS_ANNOUNCEMENT = "is_announcement"
        const val ANNOUNCEMENT = "announcement"
        const val ANNOUNCER = "announcer"
        const val ANNOUNCE_AT = "announce_at"
        const val DISPLAY = "display"
        const val FORBID_SPEAK = "forbid_speak"
        const val ROLE = "role"
        const val STATUS = "status"
    }
}