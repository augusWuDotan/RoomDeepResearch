package com.augus.roomdeepresearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.augus.roomdeepresearch.base.RawEntity
import com.augus.roomdeepresearch.database.bean.AddressBook
import com.augus.roomdeepresearch.database.presenter.AddressBookPresenter
import com.augus.roomdeepresearch.database.presenter.IAddressBookContract

class MainActivity : AppCompatActivity() {

    var addressBookPresenter: AddressBookPresenter? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addressBookPresenter = AddressBookPresenter(addressBookView)
        val addressBooks = RawEntity.initAddressBookEntryList(resources)
        Log.d(this.packageName,"AddressBook: ${addressBooks}")
        addressBookPresenter?.inserAddressBooks(addressBooks)
    }
    
    private var addressBookView = object : IAddressBookContract.IAddressBookView{
        override fun inserAddressBooksSuccess(insertResults: MutableList<Long>?) {
            Log.d("addressBookView","inserAddressBooksSuccess insertResults: ${insertResults}")
            addressBookPresenter?.getAddressBooks()
        }

        override fun getAddressBooksSuccess(addressBooks: MutableList<AddressBook>?) {
            Log.d("addressBookView","getAddressBooksSuccess addressBooks: ${addressBooks}")
        }

        override fun showLoading() {
            
        }

        override fun hideLoading() {
            
        }

        override fun showError(message: String?) {
            
        }
    }
}
