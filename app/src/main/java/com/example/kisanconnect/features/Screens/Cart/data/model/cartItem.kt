package com.example.kisanconnect.features.Screens.Cart.data.model

data class cartItem(
    val productId:String,
    val quantity: Int
)


data class cartItems(
    val cartItems:List<cartItem>
)


data class cartItemUI(
    val productId: String,
    val name:String,
    val quantity:Int,
    val price:Int,
    val unit:String,
    val stock:Int,
    val image:String
)
