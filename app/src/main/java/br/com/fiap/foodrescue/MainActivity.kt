package br.com.fiap.foodrescue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.foodrescue.ui.screens.auth.login.LoginScreen
import br.com.fiap.foodrescue.ui.screens.auth.register.RegisterScreen
import br.com.fiap.foodrescue.ui.screens.explore.ExploreScreen
import br.com.fiap.foodrescue.ui.screens.home.HomeScreen
import br.com.fiap.foodrescue.ui.screens.initial.InitialScreen
import br.com.fiap.foodrescue.ui.screens.pickUp.PickUpScreen
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRescueTheme {
                InitialScreen()
                //LoginScreen()
                //RegisterScreen()
                //HomeScreen()
                //ExploreScreen()
                //PickUpScreen()
            }
        }
    }
}