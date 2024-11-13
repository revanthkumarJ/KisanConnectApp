package com.example.kisanconnect.features.Screens.BuyNow.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisanconnect.R
import com.example.kisanconnect.core.ui.IntegerRangeDropdown
import com.example.kisanconnect.core.utilities.decodeBase64ToBitmap
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.BuyNow.data.model.BuyNowItem
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun BuyNowPage(modifier: Modifier)
{
    val product=BuyNowItem(
    productName = "Product",
    price = 200,
    unit = "kg",
    stock = 40,
    image = imageBase(),
    deliveryTime = "bjbj",
    )
    val bitmap = decodeBase64ToBitmap(product.image)
    var quantity by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier= modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Order Details:",
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )


        if (bitmap != null) {
            Image(
                painter = BitmapPainter(bitmap.asImageBitmap()),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Default Image",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
        }

        Text(text = product.productName,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(4.dp)
        )

        Text(text = "Price: ${product.price}/${product.unit}",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(4.dp)
        )

        Text(text = "Current Stock: ${product.stock}",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(4.dp)
        )

        Text(text = "Delivery In ${product.deliveryTime}",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(5.dp)
                .padding(bottom = 8.dp)
        )
    
        IntegerRangeDropdown(initialText = "Select Quantity", start = 1, initialValue = 1 ,end =product.stock ) {
            quantity=it
        }

        Text(text = "Total Amount Payable:",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(5.dp)
                .padding(top = 8.dp)
        )

        Text(text = (product.price*quantity).toString(),
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(4.dp)
        )

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
            ) {
            Text(text = "Buy Now",modifier=Modifier.padding(5.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}


@PreviewLightDark
@Composable
fun BuyNowPagePreview()
{
    KisanConnectTheme {
        BuyNowPage(modifier = Modifier)
    }
}