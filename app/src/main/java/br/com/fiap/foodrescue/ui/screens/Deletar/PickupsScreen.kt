package br.com.fiap.foodrescue.ui.screens.Deletar


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

// Figma color palette
val GreenPrimary = Color(0xFF38704D)
val LightGreenBackground = Color(0xFFEAF2EB)
val OrangeAlert = Color(0xFFFF7A45)
val GrayText = Color(0xFF8C8C8C)
val BorderGray = Color(0xFFEBEBEB)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickupsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Pickups",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = GreenPrimary
        )

        Text(
            text = "You have 2 active pickups today",
            fontSize = 14.sp,
            color = GrayText,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        HorizontalDivider(color = BorderGray, thickness = 1.dp)

        Spacer(modifier = Modifier.height(16.dp))

        // Scrollable and responsive list
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                PickupCard(
                    code = "#RV-4819",
                    title = "Mixed Fruits",
                    location = "Vila Market • 0.8km away",
                    date = "08/14/2026"
                )
            }
            item {
                PickupCard(
                    code = "#PA-3129",
                    title = "Artisan Breads",
                    location = "Bread & Art Bakery • 1.2km away",
                    date = "08/14/2026"
                )
            }
        }
    }
}

@Composable
fun PickupCard(code: String, title: String, location: String, date: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, BorderGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Active Tag and Code
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(LightGreenBackground)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Active",
                        color = GreenPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(text = "Code: $code", color = GrayText, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = location, fontSize = 14.sp, color = GrayText)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Valid until: $date", fontSize = 12.sp, color = GrayText)
            Row {
                Text(text = "Pick up by: ", fontSize = 12.sp, color = GrayText)
                Text(text = "18:00", fontSize = 12.sp, color = OrangeAlert, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // QR Code Area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(LightGreenBackground)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("QR", color = GrayText, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Present this QR code at the pickup location",
                        fontSize = 12.sp,
                        color = GrayText
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Go to the location and pick it up now ->",
                    color = GreenPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun PickUpScreenPreview() {
    FoodRescueTheme() {
        PickupsScreen()
    }
}
