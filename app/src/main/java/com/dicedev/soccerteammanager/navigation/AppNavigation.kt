package com.dicedev.soccerteammanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dicedev.soccerteammanager.screens.home.HomeScreen
import com.dicedev.soccerteammanager.screens.login.LoginScreen
import com.dicedev.soccerteammanager.screens.team.CreateTeamScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.name,
        builder = {
            composable(route = AppScreens.LoginScreen.name) {
                LoginScreen(navController = navController)
            }

            composable(route = AppScreens.HomeScreen.name) {
                HomeScreen(navController = navController)
            }

            composable(route = AppScreens.CreateTeamScreen.name) {
                CreateTeamScreen(navController = navController)
            }
        })
}