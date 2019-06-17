package com.mitrais.carrotmobile.model

import java.time.LocalDate

data class Login (var accessToken:String, var authority:String, var tokenType:String, var username:String)

data class User (var id:Int, var name:String, var type: String, var dob:String, var username:String, var picture:String, var address:String,var basket:Basket)

data class Basket (var id:Int, var carrotAmounts:Int)

data class Bazaar (var id:Int, var name:String, var startPeriod:String, var endPeriod:String, var status:Boolean, var description:String,var items:List<BazaarItem>)

data class BazaarItem(var id:Int, var name:String, var exchangeRate:Int, var totalItems:Int, var isAutoApproval:Boolean, var isOnSale:Boolean, var expireDate:String, var picture:String?)
