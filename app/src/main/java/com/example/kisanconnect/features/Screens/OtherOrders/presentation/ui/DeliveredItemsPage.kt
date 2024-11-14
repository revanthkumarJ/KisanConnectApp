package com.example.kisanconnect.features.Screens.OtherOrders.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kisanconnect.features.Screens.OtherOrders.presentation.components.DeliveredItemUI
import com.example.kisanconnect.features.Screens.OtherOrders.presentation.components.OnTheWayItemUI
import com.example.kisanconnect.features.Screens.OtherOrders.presentation.viewmodel.OtherProductsViewModel


@Composable
fun DeliveredItemsPage(modifier: Modifier, navHostController: NavHostController, viewModel: OtherProductsViewModel = hiltViewModel())
{
    var list= viewModel.delivered.value

    LaunchedEffect(Unit) {
        viewModel.getDeliveredItems()
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            Text(text = "Delivered Items",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp
            )
        }
        items(list){
            DeliveredItemUI(orderedItem = it,navHostController)
        }
    }


}



