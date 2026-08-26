package br.com.fiap.foodrescue.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun TopAppBarComponent(
    title: String,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Avatar / Logo
                Card(
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color(0xFFE0DACB),

                        )
                ) {
                    Image(
                        painter = painterResource(br.com.fiap.foodrescue.R.drawable.icon_app),
                        contentDescription = "Icon app",
                    )
                }

                // Localização
                MyLocation()
            }
            // Fim do componente Header

            // Ícone de Notificação
            NotificationBellWithBadge(count = "3", onClick = {})
        }
        
        // Título dinâmico
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            style= MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun AppLocation(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.width(200.dp)) {
        Column(modifier = modifier) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically // <--- Centraliza os 3 itens!
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = "Localização",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineSmall
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Arrow icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(start = 4.dp).size(16.dp) // Diminuí um pouco a seta para ficar mais elegante
                )
            }
            Row {
                Text(
                    modifier = Modifier.padding(start = 30.dp),
                    text = "Vila Madalena, SP",
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarComponentPreview() {
    FoodRescueTheme {
        TopAppBarComponent(title = "Home")
    }
}

// Componente do Sino de Notificação com Badge Circular
@Composable
fun NotificationBellWithBadge(
    count: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(44.dp)
            // .clip(CircleShape) removido daqui para não cortar o badge no canto!
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notificações",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )

        // Badge Redondo
        Box(
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-2).dp, y = 2.dp)
                .background(Color(0xFFE86B3E), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
