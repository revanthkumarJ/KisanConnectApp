package com.example.kisanconnect.features.Screens.Cart.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kisanconnect.features.Screens.Cart.data.model.cartItemUI
import com.example.kisanconnect.features.Screens.Cart.presentation.components.CartPageItem
import com.example.kisanconnect.features.Screens.Cart.presentation.viewmodel.CartViewModel

@Composable
fun CartPage(modifier: Modifier, viewModel: CartViewModel = hiltViewModel()) {
    val items = viewModel.cartItems.value
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    Column(modifier = modifier.fillMaxSize()) {
        if (isLoading) {
            // Show loading indicator
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (errorMessage != null) {
            // Show error message
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = errorMessage, color = androidx.compose.ui.graphics.Color.Red)
            }
        } else {
            // Display cart items
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp, horizontal = 5.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                items(items) { item ->
                    CartPageItem(item = item)
                }
            }
        }
    }
}
