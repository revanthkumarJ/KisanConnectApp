package com.example.kisanconnect.features.Screens.Home.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.kisanconnect.core.ui.ProgressIndicator
import com.example.kisanconnect.features.Screens.Home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val carousels by homeViewModel.carousels
    val fruits by homeViewModel.fruits
    val vegetables by homeViewModel.vegetables
    val grains by homeViewModel.grains
    val dairy by homeViewModel.dairy
    val others by homeViewModel.others
    val loadingState by homeViewModel.isLoading
    val errorMessage by homeViewModel.errorMessage

    val context = LocalContext.current

    // Show error message as toast if it is not null
    LaunchedEffect(errorMessage) {
        errorMessage?.let { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            homeViewModel.clearErrorMessage()  // Clear the error message after showing it
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Carousel Row
        if (loadingState.isCarouselsLoading) {
            ProgressIndicator()
        } else {
            CarouselRow(list = carousels)
        }

        // Fruits Row
        if (loadingState.isFruitsLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow(navController, "Fruits", list = fruits)
        }

        // Vegetables Row
        if (loadingState.isVegetablesLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow(navController, "Vegetables", list = vegetables)
        }

        // Grains Row
        if (loadingState.isGrainsLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow(navController, "Grains", list = grains)
        }

        // Dairy Row
        if (loadingState.isDairyLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow(navController, "Dairy", list = dairy)
        }

        // Others Row
        if (loadingState.isOthersLoading) {
            ProgressIndicator()
        } else {
            HomeScreenProductRow(navController, "Others", list = others)
        }
    }
}
