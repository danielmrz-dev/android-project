package br.com.fiap.foodrescue.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.navigation.Destination
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun MyBottomAppBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    currentRoute: String = stringResource(R.string.home) // Parâmetro novo!
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding() // Protege os ícones, mas deixa o fundo branco descer!
                .padding(vertical = 10.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = stringResource(R.string.home),
                isSelected = currentRoute == stringResource(R.string.home),
                onClick = {
                    navController
                        .navigate(
                            Destination.HomeScreen.route
                        )
                }
            )
            BottomNavItem(
                icon = Icons.Default.Search,
                label = stringResource(R.string.explore),
                isSelected = currentRoute == stringResource(R.string.explore),
                onClick = {
                    navController
                        .navigate(
                            Destination.ExploreScreen.route
                        )
                }
            )
            BottomNavItem(
                icon = Icons.Default.AllInbox,
                label = stringResource(R.string.withdrawals),
                isSelected = currentRoute == stringResource(R.string.withdrawals),
                onClick = {
                    navController
                        .navigate(
                            Destination.PickUpScreen.route
                        )
                }
            )
            BottomNavItem(
                icon = Icons.Default.PersonOutline,
                label = stringResource(R.string.profile),
                isSelected = currentRoute == stringResource(R.string.profile),
                onClick = {
                    navController
                        .navigate(
                            Destination.ProfileScreen.route
                        )
                }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview
@Composable
private fun MyBottomAppBarPreview() {
    FoodRescueTheme() {
        MyBottomAppBar(navController = rememberNavController())
    }
}