package com.example.kisanconnect.features.Screens.Product.presentation.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kisanconnect.core.ui.ProgressIndicator
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import com.example.kisanconnect.features.Screens.Product.data.remote.CartItemRequest
import com.example.kisanconnect.features.Screens.Product.presentation.components.ProductsPageDes
import com.example.kisanconnect.features.Screens.Product.presentation.components.ProductsPageImage
import com.example.kisanconnect.features.Screens.Product.presentation.viewmodel.ProductViewModel


@Composable
fun ProductPage(productId: String, modifier: Modifier,navHostController: NavHostController, viewModel: ProductViewModel = hiltViewModel()) {
    // Handle quantity state
    var quantity by remember {
        mutableIntStateOf(1)
    }

    val addSuccess = viewModel.addResult
    val context = LocalContext.current

    // Trigger getProductById whenever productId changes
    LaunchedEffect(productId) {
        viewModel.productId.value = productId
        viewModel.getProductById()
    }

    LaunchedEffect(addSuccess.value) {
        addSuccess.value?.let { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "Item Added to Cart successfully", Toast.LENGTH_SHORT).show()
                navHostController.navigate("cart")
            } else {
                Toast.makeText(context, "Failed to add item to cart", Toast.LENGTH_SHORT).show()
            }
            viewModel.addResult.value = null // Reset after displaying the message
        }
    }
    // Retrieve data from ViewModel
    val product by viewModel.product
    val isLoading by viewModel.ProductByIdIsLoading
    val errorMessage by viewModel.errorMessage

    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(bottom = 20.dp)
    ) {
        // Show loading indicator while fetching data
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), Alignment.CenterStart)
            {
                ProgressIndicator()

            }
        } else if (product != null) {
            // Display product details once data is loaded
            ProductsPageImage(image = product!!.image)
            ProductsPageDes(product = product!!, onQuantityChange ={
                quantity = it
                Log.i("RevanthQuantity", it.toString())
            }, onEditClick = { id->
                viewModel.addToCart(CartItemRequest(id,quantity))
            } , onBuyNowClick = {it->
                navHostController.navigate("buynow/${it}")
            })
        } else {
            // Handle error message if there is an issue
            errorMessage?.let {
                Text(text = "Error: $it")
            }
        }
    }
}