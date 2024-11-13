package com.example.kisanconnect.features.Screens.About.presentation

import AboutUserCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.kisanconnect.R
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.About.data.AboutUserProfileItem
import com.example.kisanconnect.ui.theme.KisanConnectTheme

val item= AboutUserProfileItem(
    name="Revanth",
    role="Team Lead",
    instagram="https://www.instagram.com/revanth_kumar_j",
    linkdeIn = "https://www.linkedin.com/in/jilakararevanthkumar/",
    github = "https://github.com/revanthkumarJ",
    facebook = "https://www.facebook.com/jilakara.revanthkumar",
    image= R.drawable.profile
)

val items=(1..3).map {
    item
}


@Composable
fun AboutUI(modifier: Modifier)
{
    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(5.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "KisanConnect",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text ="Kisan Connect is a mobile application designed to empower farmers by providing them with a user-friendly platform to access essential services, information, and tools that enhance agricultural practices. The app aims to bridge the gap between farmers and modern agricultural resources, enabling them to improve productivity and market access.",
            color = MaterialTheme.colorScheme.onBackground,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column (modifier = Modifier.padding(10.dp)){
            Text(
                text = "Technologies Used :",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp
            )
            Text(
                text ="FrontEnd : Kotlin,JetPackCompose ,Material3",
                color = MaterialTheme.colorScheme.onBackground,

                )
            Text(
                text ="BackEnd : Express, TypeScript",
                color = MaterialTheme.colorScheme.onBackground,

                )
            Text(
                text ="DataBase : MongoDb",
                color = MaterialTheme.colorScheme.onBackground,

                )
        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)

        ) {
            items(items){
                item->
                AboutUserCard(item)
            }

        }


    }
}

@PreviewLightDark
@Composable
fun AboutUIPreview()
{
    KisanConnectTheme {
        AboutUI(modifier = Modifier)
    }
}