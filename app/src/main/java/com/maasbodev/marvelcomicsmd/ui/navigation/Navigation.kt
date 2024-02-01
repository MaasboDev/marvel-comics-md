package com.maasbodev.marvelcomicsmd.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.maasbodev.marvelcomicsmd.ui.screens.Settings
import com.maasbodev.marvelcomicsmd.ui.screens.characters.CharacterDetailScreen
import com.maasbodev.marvelcomicsmd.ui.screens.characters.CharactersScreen
import com.maasbodev.marvelcomicsmd.ui.screens.comics.ComicDetailScreen
import com.maasbodev.marvelcomicsmd.ui.screens.comics.ComicsScreen
import com.maasbodev.marvelcomicsmd.ui.screens.events.EventDetailScreen
import com.maasbodev.marvelcomicsmd.ui.screens.events.EventsScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Feature.CHARACTERS.route,
    ) {
        charactersNav(navController)
        comicsNav(navController)
        eventsNav(navController)
        composable(NavCommand.ContentType(Feature.SETTINGS)) { Settings() }
    }
}

private fun NavGraphBuilder.charactersNav(navController: NavHostController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.CHARACTERS).route,
        route = Feature.CHARACTERS.route,
    ) {
        composable(NavCommand.ContentType(Feature.CHARACTERS)) {
            CharactersScreen(
                onclick = { character ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.CHARACTERS).createRoute(character.id)
                    )
                }
            )
        }

        composable(NavCommand.ContentTypeDetail(Feature.CHARACTERS)) {
            CharacterDetailScreen()
        }
    }
}

private fun NavGraphBuilder.comicsNav(navController: NavHostController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.COMICS).route,
        route = Feature.COMICS.route,
    ) {
        composable(NavCommand.ContentType(Feature.COMICS)) {
            ComicsScreen(
                onClick = { comic ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.COMICS).createRoute(comic.id)
                    )
                }
            )
        }

        composable(NavCommand.ContentTypeDetail(Feature.COMICS)) {
            ComicDetailScreen()
        }
    }
}

private fun NavGraphBuilder.eventsNav(navController: NavHostController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.EVENTS).route,
        route = Feature.EVENTS.route,
    ) {
        composable(NavCommand.ContentType(Feature.EVENTS)) {
            EventsScreen(
                onClick = { event ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.EVENTS).createRoute(event.id)
                    )
                }
            )
        }

        composable(NavCommand.ContentTypeDetail(Feature.EVENTS)) {
            EventDetailScreen()
        }
    }
}

private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ) {
        content(it)
    }
}
