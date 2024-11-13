package com.example.kisanconnect.features.Screens.BuyNow.presentation.ui

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kisanconnect.R
import com.example.kisanconnect.core.ui.IntegerRangeDropdown
import com.example.kisanconnect.core.ui.ProgressIndicator
import com.example.kisanconnect.core.utilities.decodeBase64ToBitmap
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.BuyNow.data.model.BuyNowItem
import com.example.kisanconnect.features.Screens.BuyNow.presentation.viewmodel.BuyNowViewModel
import com.example.kisanconnect.features.Screens.Product.data.model.Product
import com.example.kisanconnect.ui.theme.KisanConnectTheme
@Composable
fun BuyNowPage(modifier: Modifier = Modifier, id: String, viewModel: BuyNowViewModel = hiltViewModel()) {
    LaunchedEffect(id) {
        viewModel.getItem(id)
    }
    val addSuccess = viewModel.buyResult
    val context = LocalContext.current
    LaunchedEffect(addSuccess.value) {
        addSuccess.value?.let { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "Buyed Successfully", Toast.LENGTH_SHORT).show()
//                navHostController.navigate("cart")
            } else {
                Toast.makeText(context, "Failed to Buy Item", Toast.LENGTH_SHORT).show()
            }
            viewModel.buyResult.value = null // Reset after displaying the message
        }
    }

    val product by viewModel.product
    val isLoading by viewModel.isLoading
    val bitmap = product?.image?.let { decodeBase64ToBitmap(it) }

    var quantity by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ProgressIndicator()
            }
        } else {
            Text(
                text = "Order Details:",
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )

            bitmap?.let {
                Image(
                    painter = BitmapPainter(it.asImageBitmap()),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
            } ?: Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Default Image",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )

            Text(
                text = product?.productName ?: "N/A",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Price: ${product?.price}/${product?.unit}",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Current Stock: ${product?.stock ?: 0}",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Delivery In ${product?.deliveryTime ?: "N/A"}",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(5.dp).padding(bottom = 8.dp)
            )

            IntegerRangeDropdown(
                initialText = "Select Quantity",
                start = 1,
                initialValue = quantity,
                end = product?.stock ?: 0
            ) {
                quantity = it
            }

            Text(
                text = "Total Amount Payable:",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(5.dp).padding(top = 8.dp)
            )

            Text(
                text = (product?.price?.times(quantity)).toString(),
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(4.dp)
            )

            Button(
                onClick = { viewModel.postItem(id,quantity) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Buy Now",
                    modifier = Modifier.padding(5.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun BuyNowPagePreview() {
    KisanConnectTheme {
        BuyNowPage(
            modifier = Modifier,
            id = "sample-id"
        )
    }
}
