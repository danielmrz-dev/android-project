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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.R
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
            .statusBarsPadding()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
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
                        color = MaterialTheme.colorScheme.onSurface,

                        )
                ) {
                    Image(
                        painter = painterResource(br.com.fiap.foodrescue.R.drawable.icon_app),
                        contentDescription = stringResource(R.string.food_rescue_icon),
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
            style= MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 12.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TopAppBarComponentPreview() {
    FoodRescueTheme {
        TopAppBarComponent(title = stringResource(R.string.home))
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
            contentDescription = stringResource(R.string.notification_icon),
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.size(28.dp)
        )

        // Badge Redondo
        Box(
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-2).dp, y = 2.dp)
                .background(MaterialTheme.colorScheme.secondary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
