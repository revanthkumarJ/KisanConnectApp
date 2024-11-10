package com.example.kisanconnect.core.utilities

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

// Helper function for Social Media Icon
@Composable
fun SocialMediaIcon(url: String, description: String, context: Context, icon: Int) {
    IconButton(onClick = { openProfileLink(context, url) }) {
        Image(imageVector = ImageVector.vectorResource(id = icon), contentDescription = description, modifier = Modifier.size(40.dp))
    }
}

// Function to open URL
fun openProfileLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}