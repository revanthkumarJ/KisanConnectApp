package com.example.kisanconnect

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kisanconnect.features.Screens.About.presentation.AboutUI
import com.example.kisanconnect.features.Screens.BuyNow.presentation.ui.BuyNowPage
import com.example.kisanconnect.features.Screens.Cart.presentation.ui.CartPage
import com.example.kisanconnect.features.Screens.Home.presentation.ui.HomeScreen
import com.example.kisanconnect.features.Screens.Product.presentation.ui.ProductPage

@Composable
fun NavHostGraph(navController: NavHostController,modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left) + fadeIn()
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right) + fadeOut()
        }
    ) {
        composable("home") { HomeScreen(navController = navController,modifier=modifier) }
        composable("about") { AboutUI(modifier=modifier) }

        // Product page route with argument for productId
        composable("productPage/{productId}") { backStackEntry ->
            var productId = backStackEntry.arguments?.getString("productId")
            if(productId==null)
                productId=""
            ProductPage(productId = productId,modifier=modifier,navController)
        }

        composable("cart") { CartPage(modifier=modifier,navController) }

        composable("buynow") { BuyNowPage(modifier = modifier) }
    }
}
