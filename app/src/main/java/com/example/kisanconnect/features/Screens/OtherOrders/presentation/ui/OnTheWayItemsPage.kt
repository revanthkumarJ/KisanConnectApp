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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OnTheWayItem
import com.example.kisanconnect.features.Screens.OtherOrders.data.repository.OtherProductsRepo
import com.example.kisanconnect.features.Screens.OtherOrders.presentation.components.OnTheWayItemUI
import com.example.kisanconnect.features.Screens.OtherOrders.presentation.viewmodel.OtherProductsViewModel
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun OnTheWayItemsPage(modifier: Modifier,navHostController: NavHostController,viewModel: OtherProductsViewModel= hiltViewModel())
{
    var list= viewModel.onTheWayItems.value

    LaunchedEffect(Unit) {
        viewModel.getOnTheWayItems()
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            Text(text = "On The Way Items",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp
            )
        }
        items(list){
            OnTheWayItemUI(onTheWayItem = it,navHostController)
        }
    }


}



