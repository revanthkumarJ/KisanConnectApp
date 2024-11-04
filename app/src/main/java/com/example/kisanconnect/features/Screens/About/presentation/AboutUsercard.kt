package com.example.kisanconnect.features.Screens.About.presentation

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kisanconnect.features.Screens.About.data.AboutUserProfileItem
import com.example.kisanconnect.ui.theme.KisanConnectTheme


@Composable
fun AboutUserCard(item:AboutUserProfileItem)
{
    Card {

    }

}


@Composable
@Preview
fun AboutUserCardPreview()
{
    val item=AboutUserProfileItem(
        name="Revanth",
        role="Team Lead",
        instagram="",
        linkdeIn = "",
        github = "",
        facebook = ""
    )
    KisanConnectTheme {

    }
}