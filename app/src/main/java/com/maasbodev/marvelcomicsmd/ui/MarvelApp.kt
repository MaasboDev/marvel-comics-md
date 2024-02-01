package com.maasbodev.marvelcomicsmd.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.maasbodev.marvelcomicsmd.R
import com.maasbodev.marvelcomicsmd.ui.navigation.AppBarIcon
import com.maasbodev.marvelcomicsmd.ui.navigation.AppBottomNavigation
import com.maasbodev.marvelcomicsmd.ui.navigation.DrawerContent
import com.maasbodev.marvelcomicsmd.ui.navigation.MarvelTopAppBar
import com.maasbodev.marvelcomicsmd.ui.navigation.Navigation
import com.maasbodev.marvelcomicsmd.ui.theme.MarvelComicsMDTheme

@Composable
fun MarvelApp(appState: MarvelAppState = rememberMarvelAppState()) {

    MarvelScreen {
        ModalNavigationDrawer(
            drawerState = appState.drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    DrawerContent(
                        drawerOptions = MarvelAppState.DRAWER_OPTIONS,
                        selectedIndex = appState.drawerSelectedIndex,
                        onOptionClick = { appState.onDrawerOptionClick(it) }
                    )
                }
            }) {
            Scaffold(
                topBar = {
                    MarvelTopAppBar(
                        title = { Text(stringResource(id = R.string.app_name)) },
                        navigationIcon = {
                            if (appState.showUpNavigation) {
                                AppBarIcon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    onClick = { appState.onUpClick() })
                            } else {
                                AppBarIcon(
                                    imageVector = Icons.Default.Menu,
                                    onClick = { appState.onMenuClick() }
                                )
                            }
                        }
                    )
                },
                bottomBar = {
                    if (appState.showBottomNavigation) {
                        AppBottomNavigation(
                            bottomNavOptions = MarvelAppState.BOTTOM_NAV_OPTIONS,
                            currentRoute = appState.currentRoute,
                            onNavItemClick = { appState.onNavItemClick(it) })
                    }
                }
            ) { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(appState.navController)
                }
            }
        }

        SetStatusBarColorEffect()
    }
}

@Composable
fun MarvelScreen(content: @Composable () -> Unit) {
    MarvelComicsMDTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@Composable
private fun SetStatusBarColorEffect(
    color: Color = MaterialTheme.colorScheme.secondary,
    systemUiController: SystemUiController = rememberSystemUiController()
) {

    SideEffect {
        systemUiController.setStatusBarColor(color)
    }
}
