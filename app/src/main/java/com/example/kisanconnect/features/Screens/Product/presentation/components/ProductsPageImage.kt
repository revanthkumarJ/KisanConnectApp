package com.example.kisanconnect.features.Screens.Product.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kisanconnect.R
import com.example.kisanconnect.core.utilities.decodeBase64ToBitmap

@Composable
fun ProductsPageImage(image:String)
{
    val bitmap= decodeBase64ToBitmap(image)
    Box(modifier =Modifier.fillMaxWidth().height(200.dp).padding(5.dp),
        Alignment.Center
        )
    {
        if (bitmap != null) {
            Image(
                painter = BitmapPainter(bitmap.asImageBitmap()),
                contentDescription = "Revanth",
                modifier = Modifier.fillMaxWidth()
            )
        }
        else
        {
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription ="Default Image",
                modifier = Modifier.height(200.dp)
            )
        }
    }
}