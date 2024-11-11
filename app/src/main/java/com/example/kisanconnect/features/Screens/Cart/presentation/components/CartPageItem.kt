package com.example.kisanconnect.features.Screens.Cart.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.kisanconnect.R
import com.example.kisanconnect.core.utilities.decodeBase64ToBitmap
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.Cart.data.model.cartItemUI
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun CartPageItem(item: cartItemUI){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Product image and details
            Row(modifier = Modifier.fillMaxWidth()) {
                var bitmap = decodeBase64ToBitmap(item.image)
                if (bitmap != null) {
                    Image(
                        painter = BitmapPainter(bitmap.asImageBitmap()),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp),
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
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(150.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = item.name, style = MaterialTheme.typography.bodyLarge, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(text = "${item.price} / ${item.unit}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Quantity Selected: ${item.quantity}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Stock: ${item.stock}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Amount:${item.quantity*item.price}", style = MaterialTheme.typography.bodyLarge)
                }
            }

            // Buttons - 'Remove' and 'Buy Now'
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Remove Button
                Button(
                    onClick = { /* Handle remove action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.padding(end = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete Button",
                            tint = Color.Red
                        )
                        Text(text = "Remove", color = MaterialTheme.colorScheme.onSurface)
                    }
                }

                // Buy Now Button
                Button(
                    onClick = { /* Handle buy now action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Buy Now Button",
                            tint = Color.White
                        )
                        Text(text = "Buy Now", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
fun CartPagePreview() {
    KisanConnectTheme {
        CartPageItem(
            item = cartItemUI(
                productId = "123",
                name = "Sample Product",
                quantity = 3,
                price = 150,
                unit = "kg",
                stock = 50,
                image = imageBase() // Base64 encoded image string or empty string
            )
        )
    }
}
