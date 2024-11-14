package com.example.kisanconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kisanconnect.features.Screens.About.presentation.AboutUI
import com.example.kisanconnect.features.Screens.Home.presentation.ui.HomeScreen
import com.example.kisanconnect.ui.theme.KisanConnectTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KisanConnectTheme {
                val items = listOf(
                    NavigationItem("Home", Icons.Filled.Home, Icons.Outlined.Home),
                    NavigationItem("About", Icons.Filled.Info, Icons.Outlined.Info),
                    NavigationItem("Profile", Icons.Filled.Person, Icons.Outlined.Person),
                    NavigationItem(title="Cart",Icons.Filled.ShoppingCart,Icons.Outlined.ShoppingCart),
                    NavigationItem(title="OnTheWay",Icons.Filled.Face,Icons.Outlined.Face),
                    NavigationItem(title="Delivered",Icons.Filled.Face,Icons.Outlined.Face)

                )

                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val navController = rememberNavController()
                var selectedItemIndex by remember { mutableStateOf(0) }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.9f)) {
                            items.forEachIndexed { index, item ->
                                NavigationDrawerItem(
                                    label = { Text(text = item.title) },
                                    selected = index == selectedItemIndex, // Default selection to "Home"
                                    onClick = {
                                        selectedItemIndex=index
                                        navController.navigate(item.title.lowercase())
                                        scope.launch { drawerState.close() }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == 0) item.selectedIcon else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    },
                                    colors = NavigationDrawerItemDefaults.colors(
                                        selectedContainerColor = Color(0xFFD8F3DC), // Light green for selected item
                                        unselectedContainerColor = Color.Transparent
                                    ),
                                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                )
                            }
                        }
                    }
                ) {
                    Scaffold(
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = { Text(text = "Kisan Connect") },
                                navigationIcon = {
                                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                                    }
                                },
                                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                    containerColor = Color(0xFFA8E6CF), // Light green color for top bar
                                    titleContentColor = Color.White,
                                    navigationIconContentColor = Color.White
                                )
                            )
                        }
                        , containerColor = MaterialTheme.colorScheme.background
                    ) { innerPadding ->
                            NavHostGraph(navController = navController, modifier =Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
