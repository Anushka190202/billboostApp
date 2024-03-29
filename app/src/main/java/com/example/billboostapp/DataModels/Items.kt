package com.example.billboostapp.DataModels

import java.io.Serializable

data class Items(

    var sno:Int?=null,
    var itemName:String?=null,
    var quantity:String?=null,
    var price_per_item:String?=null,
    var total:String?=null,
): Serializable {


}
