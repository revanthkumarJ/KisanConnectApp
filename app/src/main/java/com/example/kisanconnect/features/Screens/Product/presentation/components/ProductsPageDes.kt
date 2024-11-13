package com.example.kisanconnect.features.Screens.Product.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kisanconnect.core.ui.IntegerRangeDropdown
import com.example.kisanconnect.core.utilities.formatDateToReadableFormat
import com.example.kisanconnect.features.Screens.Product.data.remote.CartItemRequest
import com.example.kisanconnect.features.Screens.Product.presentation.viewmodel.ProductViewModel
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun ProductsPageDes(product: Product,
                    viewModel: ProductViewModel= hiltViewModel(),onQuantityChange:(Int)->Unit,onEditClick:(String)->Unit
                    ) {
    Log.i("RevanthStock",product.stock.toString())
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title with larger font size and text color from the theme
        Text(
            text = product.productName,
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 28.sp),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp)) // Add spacing between title and row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            Text(
                text = product.category,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = product.farmingMethod,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Spacer(modifier = Modifier.height(10.dp)) // Add spacing between row and description

        // Product description with some spacing
        Text(
            text = product.description,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(12.dp)) // Add spacing after description

        // Price with a larger font size and text color from the theme
        Text(
            text = "${product.price}/${product.unit}",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp)) // Add spacing between price and stock info

        if(product.stock>0)
        {
            Text(
                text = "Current Stock: ${product.stock}",
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        else{
            Text(
                text = "Out Of Stock",
                color = Color.Red
            )
        }
        
        Text(
            text = "Delivery In ${product.deliveryTime}",
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(10.dp)) // Add spacing between delivery and dates

        Text(
            text = "Harvest Date: ${formatDateToReadableFormat(product.harvestDate)}",
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "Expiry Date: ${formatDateToReadableFormat(product.expiryDate)}",
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(10.dp))
        IntegerRangeDropdown(initialText = "Choose Quantity", start =1 , end = product.stock, initialValue = 1,onItemSelected = onQuantityChange)

        Spacer(modifier = Modifier.height(12.dp)) // Add spacing before buttons

        // Add to Cart button with light green background and white text
        Button(
            onClick = { onEditClick(product._id)  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF66BB6A)) // Light green
        ) {
            Text(text = "Add To Cart", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp)) // Add spacing between Add to Cart and Buy Now button

        // Buy Now button with light green background and white text
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF66BB6A)) ,
            enabled = (product.stock>0)
        ) {
            Text(text = "Buy Now", color = Color.White)
        }
    }
}

@Composable
@PreviewLightDark
fun ProductsPageDesPreview() {
    KisanConnectTheme {
        ProductsPageDes(
            product = Product(
                _id = "jjbjbjbb",
                productName = "Fresh Mangoes",
                category = "Fruits",
                description = """
                Organic and fresh mangoes directly from the farm. 
                Rich in flavor and nutrients, ideal for making fresh juices, smoothies, or enjoying as is. 
                Handpicked to ensure the best quality. 
                These mangoes are grown using sustainable farming practices.
                Available in various sizes.
            """.trimIndent(),
                price = 200,
                unit = "kg",
                stock = 50,
                image = imageBase(),
                harvestDate = "2024-09-01T00:00:00.000Z",
                expiryDate = "2024-09-15T00:00:00.000Z",
                farmingMethod = "Organic",
                deliveryTime = "2-3 days",
            ),onQuantityChange = { quantity ->
                println("Selected Quantity: $quantity")
            }, onEditClick = {

            }
        )
    }
}
