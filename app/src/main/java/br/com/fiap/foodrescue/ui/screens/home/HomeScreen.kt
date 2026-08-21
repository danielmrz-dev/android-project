package br.com.fiap.foodrescue.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {MyTopAppBar()},
        bottomBar = {},
    ) { paddingValues ->
        ContentScreen(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun HomeScreenPreview() {
    FoodRescueTheme {
        HomeScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        title = {
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
            ) {
                Row() {
                    Card(modifier = Modifier
                        .size(50.dp),
                        shape = CircleShape,
                        colors = CardDefaults
                            .cardColors(
                                containerColor = Color.Transparent
                            )
                    ) {
                        Image(
                            painter = painterResource(br.com.fiap.foodrescue.R.drawable.icon_app),
                            contentDescription = "Icon app"
                        )
                    }
                    MyLocation()
                    Spacer(modifier = Modifier.padding(start = 70.dp))
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = "Notification icon",
                        modifier = Modifier
                            .padding(8.dp)


                    )
                }
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Row() {
                    Text(
                        text = "Home",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    )
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun MyTopAppBarPreview() {
    FoodRescueTheme() {
        Surface {
            MyTopAppBar()
        }
    }
}

@Composable
fun MyLocation(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(200.dp)
    ){
        Column(modifier = modifier) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location icon",
                    tint = Color.Gray
                )
                Text(
                    modifier = Modifier
                        .padding(start = 6.dp),
                    text = "Location",
                    color = Color.Gray,
                    style = MaterialTheme.typography.headlineSmall
                )
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Arrow icon",
                    tint = Color.Gray
                )
            }
            Row() {
                Text(
                    modifier = Modifier
                        .padding(start = 30.dp),
                    text = "Vila Madalena, SP",
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun MyLocationPreview() {
    FoodRescueTheme() {
        MyLocation()
    }
}

@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
    
}

@Preview
@Composable
private fun MyBottomAppBarPreview() {
    FoodRescueTheme() {
        MyBottomAppBar()
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier) {
    
}

@Preview
@Composable
private fun ContentScreenPreview() {
    FoodRescueTheme() {
        ContentScreen()
    }
}