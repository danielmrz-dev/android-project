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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding(), // Garante que a barra de gestos do celular não sobreponha
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(icon = Icons.Default.Home, label = "Home", isSelected = true, onClick = {})
            BottomNavItem(icon = Icons.Default.Search, label = "Explorar", isSelected = false, onClick = {})

            // Botão Central (+)
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(color = Color(0xFF3D714B), RoundedCornerShape(16.dp))
                    .clickable {},
                contentAlignment = Alignment.Center,

                ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "plus icon",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            BottomNavItem(icon = Icons.Default.FavoriteBorder, label = "Retiradas", isSelected = false, onClick = {})
            BottomNavItem(icon = Icons.Default.PersonOutline, label = "Perfil", isSelected = false, onClick = {})
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
            tint = if (isSelected) Color(0xFF3D714B) else MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            color = if (isSelected) Color(0xFF3D714B) else MaterialTheme.colorScheme.onBackground,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Preview
@Composable
private fun MyBottomAppBarPreview() {
    FoodRescueTheme() {
        MyBottomAppBar()
    }
}