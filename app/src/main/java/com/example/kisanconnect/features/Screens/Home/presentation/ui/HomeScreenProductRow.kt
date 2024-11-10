package com.example.kisanconnect.features.Screens.Home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import com.example.kisanconnect.features.Screens.Home.presentation.componenets.HomeScreenProductCardUI


@Composable
fun HomeScreenProductRow(navHostController: NavHostController,type: String, list: List<HomeScreenProductCardItemUI>) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 4.dp) // Add padding inside the card
        ) {
            Text(
                text = type,
                modifier = Modifier.padding(start = 2.dp),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface, // Text color based on theme
                fontWeight = FontWeight.Bold // Make the header text bold
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(list) { item ->
                    HomeScreenProductCardUI(item = item, navController = navHostController)
                }
            }
        }
}

