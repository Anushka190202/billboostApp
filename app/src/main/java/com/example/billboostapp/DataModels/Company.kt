package com.example.billboostapp.DataModels

import android.provider.ContactsContract
data class Company(
    var companyName:String,
    var contact:String,
    var email: ContactsContract.CommonDataKinds.Email,
    var address:String
)
