package br.com.fiap.foodrescue.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.foodrescue.ui.screens.auth.login.LoginScreen
import br.com.fiap.foodrescue.ui.screens.auth.register.RegisterScreen
import br.com.fiap.foodrescue.ui.screens.explore.ExploreScreen
import br.com.fiap.foodrescue.ui.screens.home.HomeScreen
import br.com.fiap.foodrescue.ui.screens.pickUp.PickUpScreen
import br.com.fiap.foodrescue.ui.screens.profile.ProfileScreen

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.LoginScreen.route
    ){
        composable(Destination.LoginScreen.route){
            LoginScreen(navController)
        }

        composable(Destination.RegisterScreen.route){
            RegisterScreen(navController)
        }

        composable(Destination.HomeScreen.route){
            HomeScreen(navController)
        }

        composable(Destination.ExploreScreen.route){
            ExploreScreen(navController)
        }

        composable(Destination.PickUpScreen.route){
            PickUpScreen(navController)
        }

        composable(Destination.ProfileScreen.route) {
            ProfileScreen(navController)
        }
    }
}