package br.com.fiap.foodrescue.ui.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .padding(top = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Card(
                        modifier = Modifier.size(50.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color.Gray
                        )
                    ) {
                        Image(
                            painter = painterResource(R.drawable.icon_app),
                            contentDescription = "Icon app"
                        )
                    }
                    AppLocation()
                }

                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = "Notification icon",
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = query,
                onValueChange = { query = it },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Pesquise doações próximas a você...",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon"
                    )
                }
            )
        }
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
private fun AppTopBarPreview() {
    FoodRescueTheme {
        AppTopBar(title = "Home")
    }
}
