package com.example.kisanconnect.core.utilities

import java.text.SimpleDateFormat
import java.util.*

fun formatDateToReadableFormat(dateString: String): String {
    // Parse the input date string in the format you're receiving (e.g., ISO 8601)
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) // Change this to your preferred format

    return try {
        val date = inputFormat.parse(dateString)
        outputFormat.format(date!!)
    } catch (e: Exception) {
        "Invalid Date" // Return a default value if the date parsing fails
    }
}
