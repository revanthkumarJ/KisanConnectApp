package com.example.kisanconnect.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Green40,
    secondary = Brown40,
    tertiary = Orange40,
//    background = Color(0xFF1B1F23),
    surface = Color(0xFF2E2E2E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFFF5F5F5),
    onSurface = Color(0xFFEFEFEF)
)

private val LightColorScheme = lightColorScheme(
    primary = Green80,
    secondary = Brown80,
    tertiary = Orange80,
//    background = Color(0xFFFFFFFF),
    surface = Color(0xFFF5F5F5),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color(0xFF1B1F23),
    onSurface = Color(0xFF2E2E2E)
)

@Composable
fun KisanConnectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}