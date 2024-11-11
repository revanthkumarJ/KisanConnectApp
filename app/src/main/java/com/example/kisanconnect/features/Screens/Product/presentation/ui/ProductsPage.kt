package com.example.kisanconnect.features.Screens.Product.presentation.ui

import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kisanconnect.core.ui.ProgressIndicator
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import com.example.kisanconnect.features.Screens.Product.presentation.components.ProductsPageDes
import com.example.kisanconnect.features.Screens.Product.presentation.components.ProductsPageImage
import com.example.kisanconnect.features.Screens.Product.presentation.viewmodel.ProductViewModel


@Composable
fun ProductPage(productId: String, modifier: Modifier, viewModel: ProductViewModel = hiltViewModel()) {
    // Handle quantity state
    var quantity by remember {
        mutableIntStateOf(1)
    }

    // Trigger getProductById whenever productId changes
    LaunchedEffect(productId) {
        viewModel.productId.value = productId
        viewModel.getProductById()
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
            ProductsPageDes(product = product!!) {
                quantity = it
                Log.i("RevanthQuantity", it.toString())
            }
        } else {
            // Handle error message if there is an issue
            errorMessage?.let {
                Text(text = "Error: $it")
            }
        }
    }
}