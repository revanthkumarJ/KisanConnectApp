package com.example.kisanconnect.features.Screens.OtherOrders.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kisanconnect.core.utilities.formatDateToReadableFormat
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OnTheWayItem
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OrderedItemX


@Composable
fun DeliveredItemUI(orderedItem: OrderedItemX, navHostController: NavHostController)
{

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        , onClick = {
            navHostController.navigate("productPage/${orderedItem.productId._id}")
        }
    ) {
        Text(text = orderedItem.productName, modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp).padding(top = 10.dp)
            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 22.sp)
        Text(text = "Product Id: ${orderedItem.productId._id}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
        Text(text = "Quantity Delivered:${orderedItem.quantity}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
        Text(text = "Ordered on:${formatDateToReadableFormat(orderedItem.orderedDate)}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
        Text(text = "Amount Payed:${orderedItem.amount}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp).padding(bottom = 10.dp))
    }
}
