package br.com.fiap.foodrescue.ui.screens.pickUp


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.components.MyBottomAppBar
import br.com.fiap.foodrescue.ui.components.TopAppBarComponent
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun PickUpScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { TopAppBarComponent(title = stringResource(R.string.withdrawals)) },
        bottomBar = { MyBottomAppBar(currentRoute = stringResource(R.string.withdrawals)) }
    ) { paddingValues ->
        PickUpContentScreen(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun PickUpContentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background) // Fundo da tela Branco
            .padding(horizontal = 20.dp)
    ) {
        // Subtítulo
        Text(
            text = stringResource(R.string.you_have_2_active_withdrawals_today),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 14.sp
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Lista de Cards
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item {
                PickUpCard(
                    status = stringResource(R.string.active),
                    code = "#RV-4829",
                    title = stringResource(R.string.mixed_fruits),
                    supplier = "Sacolão da Vila",
                    distance = "0.8km",
                    date = "14/08/2026",
                    time = "18:00",
                    hasQrCodeImage = true
                )
            }
            item {
                PickUpCard(
                    status = stringResource(R.string.active),
                    code = "#PA-3124",
                    title = stringResource(R.string.artisan_breads),
                    supplier = "Padaria Pão & Arte",
                    distance = "1.2km",
                    date = "14/08/2026",
                    time = "18:00",
                    hasQrCodeImage = true
                )
            }
        }
    }
}

@Composable
fun PickUpCard(
    status: String,
    code: String,
    title: String,
    supplier: String,
    distance: String,
    date: String,
    time: String,
    hasQrCodeImage: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Cabeçalho: Tag Ativo e Código
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = status,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "Código: $code",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 12.sp
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Meio: Textos (Esquerda) e QR Code (Direita)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Coluna Esquerda
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.secondary,
                        lineHeight = 22.sp
                    )
                    Text(
                        text = stringResource(R.string.away, supplier, distance),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 13.sp
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    // Datas e Horários consolidados
                    Text(
                        text = stringResource(R.string.valid_until, date),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 12.sp
                    )
                    Row {
                        Text(
                            text = stringResource(R.string.latest_time) + " ",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 12.sp
                        )
                        Text(
                            text = time,
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                // Coluna Direita (QR Code compacto)
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(8.dp))
                        .border(
                            width = if (hasQrCodeImage) 1.dp else 2.dp,
                            color = MaterialTheme.colorScheme.onSurface,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (hasQrCodeImage) {
                        Icon(
                            imageVector = Icons.Default.QrCode2,
                            contentDescription = stringResource(R.string.qr_code),
                            modifier = Modifier.size(60.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = stringResource(R.string.present_this_qr_code_at_the_pickup_location),
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 11.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Rodapé
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {},
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = stringResource(R.string.go_to_the_location_and_pick_it_up_now),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PickUpScreenPreview() {
    FoodRescueTheme {
        PickUpScreen()
    }
}
