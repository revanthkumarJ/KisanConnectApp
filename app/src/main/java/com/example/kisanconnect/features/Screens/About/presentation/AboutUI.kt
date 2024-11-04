package com.example.kisanconnect.features.Screens.About.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun AboutUI()
{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
        .background(MaterialTheme.colorScheme.background)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "KisanConnect",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text ="Kisan Connect is a mobile application designed to empower farmers by providing them with a user-friendly platform to access essential services, information, and tools that enhance agricultural practices. The app aims to bridge the gap between farmers and modern agricultural resources, enabling them to improve productivity and market access.",
            color = MaterialTheme.colorScheme.primary,
        )

        Column (modifier = Modifier.padding(10.dp)){
            Text(
                text = "Technologies Used :",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 20.sp
            )
            Text(
                text ="FrontEnd : Kotlin,JetPackCompose ,Material3",
                color = MaterialTheme.colorScheme.primary,

                )
            Text(
                text ="BackEnd : Express, TypeScript",
                color = MaterialTheme.colorScheme.primary,

                )
            Text(
                text ="DataBase : MongoDb",
                color = MaterialTheme.colorScheme.primary,

                )
        }
    }
}

@PreviewLightDark
@Composable
fun AboutUIPreview()
{
    KisanConnectTheme {
        AboutUI()
    }
}