package com.example.kisanconnect.features.Screens.Home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kisanconnect.core.utilities.imageBase
import com.example.kisanconnect.features.Screens.About.presentation.AboutUI
import com.example.kisanconnect.features.Screens.Home.data.model.CarouselItemUI
import com.example.kisanconnect.features.Screens.Home.data.model.HomeScreenProductCardItemUI
import com.example.kisanconnect.features.Screens.Home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun HomeScreen(homeViewModel: HomeViewModel=hiltViewModel())
{
    val carousels by homeViewModel.carousels

    var item= HomeScreenProductCardItemUI(
        productName = "Apple",
        price = 20,
        unit = "kg",
        image = imageBase()
    )

    var items=(1..5).map {
        item
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(
            rememberScrollState()
        )) {
        CarouselRow(list = carousels)
        HomeScreenProductRow("Fruits",list = items)
        HomeScreenProductRow("Vegetables",list = items)
        HomeScreenProductRow("Grains",list = items)
        HomeScreenProductRow("Dairy",list = items)
        HomeScreenProductRow("Others",list = items)


    }
}