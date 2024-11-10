package com.example.kisanconnect.features.Screens.Product.data

data class Product(
    val productName:String,
    val category:String,
    val description:String,
    val price:Int,
    val unit:String,
    val stock:Int,
    val image:String,
    val harvestDate:String,
    val expiryDate:String,
    val farmingMethod:String,
    val deliveryTime:String
)
