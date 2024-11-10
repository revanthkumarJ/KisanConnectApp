package com.example.kisanconnect.features.Screens.Home.presentation.componenets

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kisanconnect.core.utilities.decodeBase64ToBitmap
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun HomeScreenProductCardUI(navController: NavHostController,item: HomeScreenProductCardItemUI) {
    val bitmap = decodeBase64ToBitmap(item.image)

    Card(
        onClick = {
            navController.navigate("productPage/${item._id}")
        },
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Use the surface color from the MaterialTheme
        ),
        modifier = Modifier
            .width(120.dp)
            .height(170.dp)
            .padding(4.dp) // Padding around the card itself
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            if (bitmap != null) {
                Image(
                    painter = BitmapPainter(bitmap.asImageBitmap()),
                    contentDescription = item.productName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = item.productName,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "${item.price}/${item.unit}",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

var item= HomeScreenProductCardItemUI(
    productName = "Apple",
    price = 20,
    unit = "kg",
    image = imageBase(),
    _id = "nsjbsjjsj"
)



@Composable
@PreviewLightDark
fun HomeScreenProductCardItemUIPreview()
{
    KisanConnectTheme {
        HomeScreenProductCardUI(item =item , navController = rememberNavController())
    }
}