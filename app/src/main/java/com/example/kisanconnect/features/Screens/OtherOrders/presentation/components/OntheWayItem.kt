package com.example.kisanconnect.features.Screens.OtherOrders.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kisanconnect.features.Screens.OtherOrders.data.model.OnTheWayItem
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun OnTheWayItemUI(onTheWayItem: OnTheWayItem,navHostController: NavHostController)
{

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        , onClick = {
            navHostController.navigate("productPage/${onTheWayItem.productId}")
        }
    ) {
        Text(text = onTheWayItem.productName, modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp).padding(top = 10.dp)
            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 22.sp)
        Text(text = "Product Id: ${onTheWayItem.productId}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
        Text(text = "Quantity Ordered:${onTheWayItem.quantity}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
        Text(text = "Amount Payable:${onTheWayItem.amount}", modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp).padding(bottom = 10.dp))
    }

}



//@Composable
//@PreviewLightDark
//fun OnTheWayItemPreview()
//{
//    KisanConnectTheme {
//        OnTheWayItemUI(onTheWayItem = OnTheWayItem(
//            productId= "6714db3bd4f970303751a658",
//            productName= "Apple",
//            quantity= 6,
//            orderedDate= "2024-11-14T15:32:47.630Z",
//            amount= 900,
//        ))
//    }
//}

