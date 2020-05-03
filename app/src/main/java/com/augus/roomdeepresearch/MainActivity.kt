package com.augus.roomdeepresearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.augus.roomdeepresearch.base.RawEntity
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.bean.ChatListRoomBean
import com.augus.roomdeepresearch.database.bean.ChatListWithAddress
import com.augus.roomdeepresearch.database.presenter.TestPresenter
import com.augus.roomdeepresearch.database.presenter.ITestContract

class MainActivity : AppCompatActivity() {

    var addressBookPresenter: TestPresenter? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addressBookPresenter = TestPresenter(addressBookView)
        val addressBooks = RawEntity.initAddressBookEntryList(resources)
        val chatLists = RawEntity.initChatListEntryList(resources)
        Log.d(this.packageName,"AddressBook: $addressBooks")
        Log.d(this.packageName,"chatLists: $chatLists")
        addressBookPresenter?.inserAddressBooks(addressBooks)
        addressBookPresenter?.inserChatLists(chatLists)
    }
    
    private var addressBookView = object : ITestContract.ITestView{
        override fun inserAddressBooksSuccess(insertResults: MutableList<Long>?) {
            Log.d("testView","inserAddressBooksSuccess insertResults: $insertResults")
            addressBookPresenter?.getAddressBooks()
        }

        override fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?) {
            Log.d("testView","getAddressBooksSuccess addressBooks: $addressBooks")
        }

        override fun inserChatListsSuccess(insertResults: MutableList<Long>?) {
            Log.d("testView","inserChatListsSuccess insertResults: $insertResults")
            addressBookPresenter?.getChatLists()
        }

        override fun getChatListsSuccess(chatLists: MutableList<ChatListRoomBean>?) {
            Log.d("testView","getChatListsSuccess chatLists: $chatLists")
            addressBookPresenter?.getChatListWithAddressBooks()
        }

        override fun getChatListWithAddressBooksSuccess(chatListWithAddress: MutableList<ChatListWithAddress>?) {
            Log.d("testView","getChatListWithAddressBooksSuccess chatListWithAddress: ${chatListWithAddress}")
            chatListWithAddress?.forEach {
                Log.d("testView","getChatListWithAddressBooksSuccess chatListRoomBean: ${it.chatListRoomBean} , addressBooks: ${it.getAddressBook()}")
            }
        }

        override fun showLoading() {
            
        }

        override fun hideLoading() {
            
        }

        override fun showError(message: String?) {
            
        }


    }
}
