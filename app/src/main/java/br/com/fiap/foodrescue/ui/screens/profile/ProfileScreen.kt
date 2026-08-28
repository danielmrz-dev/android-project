package br.com.fiap.foodrescue.ui.screens.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Grain
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.components.MyBottomAppBar
import br.com.fiap.foodrescue.ui.components.TopAppBarComponent
import br.com.fiap.foodrescue.ui.navigation.Destination
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { TopAppBarComponent(title = stringResource(R.string.profile)) },
        bottomBar = { MyBottomAppBar(navController = navController, currentRoute = stringResource(R.string.profile)) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentPadding = PaddingValues(15.dp, 11.dp, 15.dp, 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item { UserCard(navController) }
                item { ImpactCard() }
                item { AchievementsCard() }
                item { SettingsCard() }
            }
    }
}



// Card com os dados da usuária
@Composable
private fun UserCard(navController: NavController) {
    ProfileCard {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.profile_avatar),
                contentDescription = "Foto de Carol Silva",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    //.border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    "Carol Silva",
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    ProfileTag(stringResource(R.string.eco_hero), MaterialTheme.colorScheme.primary)
                    ProfileTag(
                        text = stringResource(R.string.streak_14_days),
                        color = MaterialTheme.colorScheme.secondary,
                        icon = Icons.Default.LocalFireDepartment
                    )
                }
            }
            TextButton(onClick = {
                navController
                    .navigate(
                        Destination.LoginScreen.route
                    )
            }) {
                Text(
                    stringResource(R.string.log_out),
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Card com os números de impacto ambiental
@Composable
private fun ImpactCard() {
    ProfileCard {
        Column(modifier = Modifier.padding(16.dp)) {
            SectionTitle(stringResource(R.string.your_environmental_impact))
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ImpactItem(Icons.Default.Restaurant, "145", stringResource(R.string.saved_meals), Modifier.weight(1f))
                ImpactItem(Icons.Default.Scale, "360 kg", stringResource(R.string.saved_food), Modifier.weight(1f), true)
                ImpactItem(Icons.Default.Eco, "62 kg", stringResource(R.string.co2_avoided), Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun ImpactItem(
    icon: ImageVector,
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    orange: Boolean = false
) {
    val color = if (orange) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(color = color.copy(alpha = 0.10f), shape = RoundedCornerShape(12.dp), modifier = Modifier.size(36.dp)) {
            Box(contentAlignment = Alignment.Center) {
                Icon(icon, null, Modifier.size(20.dp), tint = color)
            }
        }
        Text(value, color = color, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 4.dp))
        Text(
            label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 11.sp,
            lineHeight = 13.sp,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

// Card de conquistas
@Composable
private fun AchievementsCard() {
    ProfileCard {
        Column(modifier = Modifier.padding(16.dp)) {
            SectionTitle(stringResource(R.string.unlocked_achievements))
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AchievementItem(Icons.Default.Grain, stringResource(R.string.bakery_master), Modifier.weight(1f))
                AchievementItem(Icons.Default.Spa, stringResource(R.string.veggie_hero), Modifier.weight(1f))
                AchievementItem(Icons.Default.EmojiEvents, stringResource(R.string.savior_100), Modifier.weight(1f), orange = true)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AchievementItem(Icons.Default.Cancel, stringResource(R.string.streak_30_days), Modifier.weight(1f), enabled = false)
                AchievementItem(Icons.Default.Recycling, stringResource(R.string.zero_waste), Modifier.weight(1f), enabled = false)
                AchievementItem(Icons.Default.VolunteerActivism, stringResource(R.string.frequent_rescuer), Modifier.weight(1f), enabled = false)
            }
        }
    }
}

@Composable
private fun AchievementItem(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    orange: Boolean = false,
    enabled: Boolean = true
) {
    val color = if (orange) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary

    Column(
        modifier = modifier.alpha(if (enabled) 1f else 0.38f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = color.copy(alpha = 0.08f),
            shape = CircleShape,
            modifier = Modifier
                .size(44.dp)
                .border(1.dp, color, CircleShape)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(icon, null, Modifier.size(25.dp), tint = color)
            }
        }
        Text(
            label,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 10.sp,
            lineHeight = 12.sp,
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

// Opções da conta
@Composable
private fun SettingsCard() {
    val settings = listOf(
        stringResource(R.string.account_settings),
        stringResource(R.string.rescue_history),
        stringResource(R.string.privacy_policy),
        stringResource(R.string.about_foodrescue_esg)
    )

    ProfileCard {
        Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)) {
            settings.forEachIndexed { index, title ->
                SettingsRow(title)
                if (index < settings.lastIndex) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline)
                }
            }
        }
    }
}

@Composable
private fun SettingsRow(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 36.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
    }
}



@Composable
private fun ProfileCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        content()
    }
}

@Composable
private fun ProfileTag(text: String, color: Color, icon: ImageVector? = null) {
    Surface(color = color.copy(alpha = 0.10f), shape = RoundedCornerShape(6.dp)) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(12.dp)
                )
            }
            Text(
                text = text,
                color = color,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(title, color = MaterialTheme.colorScheme.primary, fontSize = 15.sp, fontWeight = FontWeight.Bold)
}

@Preview(
    name = "Perfil claro",
    showBackground = true,
    widthDp = 412,
    heightDp = 915,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun ProfileScreenLightPreview() {
    FoodRescueTheme(darkTheme = false) { ProfileScreen(rememberNavController()) }
}

@Preview(
    name = "Perfil escuro",
    showBackground = true,
    widthDp = 412,
    heightDp = 915,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ProfileScreenDarkPreview() {
    FoodRescueTheme(darkTheme = true) { ProfileScreen(rememberNavController()) }
}
