package br.com.fiap.foodrescue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.foodrescue.ui.navigation.NavigationRoutes
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRescueTheme {
                NavigationRoutes()
            }
        }
    }
}