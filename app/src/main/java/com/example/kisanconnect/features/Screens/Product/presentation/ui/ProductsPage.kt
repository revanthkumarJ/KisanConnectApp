package com.example.kisanconnect.features.Screens.Product.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.Product.data.Product
import com.example.kisanconnect.features.Screens.Product.presentation.components.ProductsPageDes
import com.example.kisanconnect.features.Screens.Product.presentation.components.ProductsPageImage


@Composable
fun ProductPage(productId:String,modifier: Modifier)
{
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        )
    {
        ProductsPageImage(image = imageBase())
        ProductsPageDes(product = Product(
            productName = "Fresh Mangoes",
            category = "Fruits",
            description = "Organic and fresh mangoes directly from the farm.Rich in flavor and nutrients, ideal for making fresh juices, smoothies, or enjoying as is. Handpicked to ensure the best quality.These mangoes are grown using sustainable farming practices.Available in various sizes.",
            price = 200,
            unit = "kg",
            stock = 50,
            image = imageBase(),
            harvestDate = "2024-09-01T00:00:00.000Z",
            expiryDate = "2024-09-15T00:00:00.000Z",
            farmingMethod = "Organic",
            deliveryTime = "2-3 days",
            )
        )

    }
}


@Preview
@Composable
fun ProductPagePreview()
{
    ProductPage(productId = imageBase(), modifier =Modifier)

}