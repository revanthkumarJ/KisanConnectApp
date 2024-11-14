import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kisanconnect.R
import com.example.kisanconnect.core.utilities.decodeBase64ToBitmap
import com.example.kisanconnect.features.Screens.Cart.data.model.cartItemUI
import com.example.kisanconnect.features.Screens.Cart.presentation.viewmodel.CartViewModel

@Composable
fun CartPageItem(item: cartItemUI, navController:NavHostController,viewModel: CartViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val deleteSuccess = viewModel.deleteResult // State to observe delete result

    Card(
        onClick = {
            navController.navigate("productPage/${item.productId}")
        },
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Product image and details
            Row(modifier = Modifier.fillMaxWidth()) {
                val bitmap = decodeBase64ToBitmap(item.image)
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
                    Text(text = "Amount: ${item.quantity * item.price}", style = MaterialTheme.typography.bodyLarge)
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
                    onClick = {
                        viewModel.OnDelete(item.productId)
                    },
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

    LaunchedEffect(deleteSuccess.value) {
        deleteSuccess.value?.let { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "Item deleted successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed to delete item", Toast.LENGTH_SHORT).show()
            }
            viewModel.deleteResult.value = null // Reset after displaying the message
        }
    }
}
