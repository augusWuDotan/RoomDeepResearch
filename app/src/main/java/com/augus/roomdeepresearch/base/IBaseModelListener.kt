package com.augus.roomdeepresearch.base

interface IBaseModelListener {
    fun onStart()
    fun complete()
    fun showError(errorMsg:String?)
}