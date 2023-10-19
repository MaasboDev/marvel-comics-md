package com.maasbodev.marvelcomicsmd.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maasbodev.marvelcomicsmd.ui.screens.characterdetail.CharacterDetailScreen
import com.maasbodev.marvelcomicsmd.ui.screens.characters.CharactersScreen

@Composable
fun Navigation() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = NavItem.Characters.route,
	) {
		composable(NavItem.Characters) {
			CharactersScreen(onclick = { character ->
				navController.navigate(NavItem.CharacterDetail.createRoute(character.id))
			})
		}

		composable(NavItem.CharacterDetail){
			CharacterDetailScreen(it.findArg(NavArg.ItemId))
		}
	}
}

private fun NavGraphBuilder.composable(
	navItem: NavItem,
	content: @Composable (NavBackStackEntry) -> Unit
) {
	composable(
		route = navItem.route,
		arguments = navItem.args
	) {
		content(it)
	}
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
	val value = arguments?.getString(arg.key)
	requireNotNull(value)
	return value as T
}