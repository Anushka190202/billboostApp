package com.example.billboostapp.DataModels

import android.provider.ContactsContract.CommonDataKinds.Email

data class Clients(
    var clientName:String,
    var contact:String,
    var email:Email,
    var address:String
)
