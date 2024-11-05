package com.example.kisanconnect.core.utilities
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
// Utility function to decode Base64 string into ImageBitmap
// Function to decode Base64 to Bitmap
fun decodeBase64ToBitmap(base64String: String): Bitmap? {
    return try {
        val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
