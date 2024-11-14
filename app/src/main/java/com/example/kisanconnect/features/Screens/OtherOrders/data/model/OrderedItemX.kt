package com.example.kisanconnect.features.Screens.OtherOrders.data.model

data class OrderedItemX(
    val _id: String,
    val amount: Int,
    val orderedDate: String,
    val productId: ProductId,
    val productName: String,
    val quantity: Int
)