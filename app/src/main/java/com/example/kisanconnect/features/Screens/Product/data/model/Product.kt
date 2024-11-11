package com.example.kisanconnect.features.Screens.Product.data.model

data class Product(
    val _id:String,
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
