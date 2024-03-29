package com.example.billboostapp.DataModels

import java.io.Serializable

data class Company(
    var name:String?=null,
    var contact:String?=null,
    var email:String?=null,
    var address:String?=null,
    var id:String?=""
): Serializable {
    override fun toString(): String {
        return name.toString()
    }


}
