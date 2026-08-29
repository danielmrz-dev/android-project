package br.com.fiap.foodrescue.ui.navigation

sealed class Destination(val route: String){

    object LoginScreen: Destination("register")

    object RegisterScreen: Destination("Signup")

    object HomeScreen: Destination("home")

    object ExploreScreen: Destination("explore")

    object PickUpScreen: Destination("pickup")

    object ProfileScreen: Destination("profile")
}