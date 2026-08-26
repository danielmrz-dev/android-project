package br.com.fiap.foodrescue.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.foodrescue.ui.screens.auth.login.LoginScreen
import br.com.fiap.foodrescue.ui.screens.auth.register.RegisterScreen
import br.com.fiap.foodrescue.ui.screens.explore.ExploreScreen
import br.com.fiap.foodrescue.ui.screens.home.HomeScreen
import br.com.fiap.foodrescue.ui.screens.initial.InitialScreen
import br.com.fiap.foodrescue.ui.screens.pickUp.PickUpScreen

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.InitialScreen.route
    ){
        composable(Destination.InitialScreen.route){
            InitialScreen()
        }

        composable(Destination.LoginScreen.route){
            LoginScreen()
        }

        composable(Destination.RegisterScreen.route){
            RegisterScreen()
        }

        composable(Destination.HomeScreen.route){
            HomeScreen()
        }

        composable(Destination.ExploreScreen.route){
            ExploreScreen()
        }

        composable(Destination.PickUpScreen.route){
            PickUpScreen()
        }
    }

    
}