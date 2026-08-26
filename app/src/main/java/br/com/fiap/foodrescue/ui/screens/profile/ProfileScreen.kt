package br.com.fiap.foodrescue.ui.screens.profile

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Contrast
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Grain
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Immutable
data class ProfileUiState(
    val name: String = "Carol Silva",
    val location: String = "Vila Madalena, SP",
    val level: String = "Eco-Herói",
    val streakDays: Int = 14,
    val notificationCount: Int = 3,
    val mealsSaved: Int = 145,
    val foodSavedKg: Int = 360,
    val co2AvoidedKg: Int = 62
)

enum class ProfileDestination { HOME, EXPLORE, ADD, PICKUPS, PROFILE }

private val ProfileLightColorScheme = lightColorScheme(
    primary = Color(0xFF3D714B),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFEAF2EC),
    onPrimaryContainer = Color(0xFF315B3C),
    secondary = Color(0xFFFF773C),
    onSecondary = Color.White,
    background = Color(0xFFF4E9CE),
    onBackground = Color(0xFF1D1B20),
    surface = Color.White,
    onSurface = Color(0xFF1D1B20),
    surfaceVariant = Color.White,
    onSurfaceVariant = Color(0xFF8E8E93),
    outline = Color(0xFFDCEBE5),
    error = Color(0xFFD32F2F)
)

private val ProfileDarkColorScheme = darkColorScheme(
    primary = Color(0xFF4DBD78),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF17251B),
    onPrimaryContainer = Color(0xFF4DBD78),
    secondary = Color(0xFFD9824A),
    onSecondary = Color.White,
    background = Color(0xFF1A1A1A),
    onBackground = Color(0xFFF7F7F7),
    surface = Color(0xFF252525),
    onSurface = Color(0xFFF7F7F7),
    surfaceVariant = Color(0xFF171A18),
    onSurfaceVariant = Color(0xFFA7A7A7),
    outline = Color(0xFF214F30),
    error = Color(0xFFFF5C5C)
)

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    state: ProfileUiState = ProfileUiState(),
    onLocationClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {},
    onThemeToggleClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
    onAccountSettingsClick: () -> Unit = {},
    onPickupHistoryClick: () -> Unit = {},
    onPrivacyPolicyClick: () -> Unit = {},
    onAboutClick: () -> Unit = {},
    onDestinationClick: (ProfileDestination) -> Unit = {}
) {
    val profileColorScheme = if (isSystemInDarkTheme()) {
        ProfileDarkColorScheme
    } else {
        ProfileLightColorScheme
    }
    val projectTypography = MaterialTheme.typography

    MaterialTheme(
        colorScheme = profileColorScheme,
        typography = projectTypography
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.TopCenter
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .widthIn(max = 362.dp),
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(23.dp)
            ) {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.surface,
                    bottomBar = { ProfileBottomBar(onDestinationClick) }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentPadding = PaddingValues(15.dp, 11.dp, 15.dp, 16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        item {
                            ProfileHeader(
                                location = state.location,
                                notificationCount = state.notificationCount,
                                onLocationClick = onLocationClick,
                                onThemeToggleClick = onThemeToggleClick,
                                onNotificationsClick = onNotificationsClick
                            )
                        }
                        item {
                            UserIdentityCard(
                                state.name,
                                state.level,
                                state.streakDays,
                                onLogoutClick
                            )
                        }
                        item { EnvironmentalImpactCard(state) }
                        item { AchievementsCard() }
                        item {
                            ProfileSettingsCard(
                                onAccountSettingsClick,
                                onPickupHistoryClick,
                                onPrivacyPolicyClick,
                                onAboutClick
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    location: String,
    notificationCount: Int,
    onLocationClick: () -> Unit,
    onThemeToggleClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.icon_app),
                contentDescription = "Logo do FoodRescue",
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
            )
            Row(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(role = Role.Button, onClick = onLocationClick)
                    .padding(horizontal = 10.dp, vertical = 2.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Column(modifier = Modifier.padding(start = 4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "Localização",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 15.sp
                        )
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(13.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Text(
                        location,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            IconButton(
                onClick = onThemeToggleClick,
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    Icons.Default.Contrast,
                    contentDescription = "Alternar tema",
                    modifier = Modifier.size(22.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            NotificationButton(notificationCount, onNotificationsClick)
        }
        Text(
            "Seu Perfil",
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.56.sp
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.outline)
    }
}

@Composable
private fun NotificationButton(count: Int, onClick: () -> Unit) {
    Box(modifier = Modifier.size(38.dp)) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.Center)
                .size(38.dp)
        ) {
            Icon(
                Icons.Default.NotificationsNone,
                contentDescription = "Abrir notificações",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        if (count > 0) {
            Surface(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(18.dp),
                color = MaterialTheme.colorScheme.secondary,
                shape = CircleShape
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        count.coerceAtMost(9).toString(),
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun UserIdentityCard(
    name: String,
    level: String,
    streakDays: Int,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ProfileCard(modifier) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.profile_avatar),
                contentDescription = "Foto de $name",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(Modifier.width(14.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    name,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProfileTag(
                        level,
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.10f)
                    )
                    ProfileTag(
                        "🔥 $streakDays dias",
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f)
                    )
                }
            }
            TextButton(
                onClick = onLogoutClick,
                contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                Text(
                    "Sair",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun EnvironmentalImpactCard(
    state: ProfileUiState,
    modifier: Modifier = Modifier
) {
    val metrics = listOf(
        ImpactMetric(Icons.Default.Restaurant, state.mealsSaved.toString(), "Refeições Salvas"),
        ImpactMetric(Icons.Default.Scale, "${state.foodSavedKg} kg", "Alimentos Salvos", true),
        ImpactMetric(Icons.Default.Eco, "${state.co2AvoidedKg} kg", "CO2 Evitado")
    )
    ProfileCard(modifier) {
        Column(Modifier.padding(16.dp)) {
            SectionTitle("Seu Impacto Ambiental")
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                metrics.forEach { metric ->
                    ImpactMetricItem(metric, Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun ImpactMetricItem(metric: ImpactMetric, modifier: Modifier = Modifier) {
    val accent = if (metric.secondary) {
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.primary
    }
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            modifier = Modifier.size(36.dp),
            shape = RoundedCornerShape(12.dp),
            color = accent.copy(alpha = 0.10f)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(metric.icon, null, Modifier.size(20.dp), tint = accent)
            }
        }
        Text(
            metric.value,
            modifier = Modifier.padding(top = 4.dp),
            color = accent,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            metric.label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            maxLines = 2,
            lineHeight = 13.sp
        )
    }
}

@Composable
private fun AchievementsCard(modifier: Modifier = Modifier) {
    val achievements = listOf(
        Achievement(Icons.Default.Grain, "Mestre da Padaria"),
        Achievement(Icons.Default.Spa, "Guerreiro do Hortifruti"),
        Achievement(Icons.Default.EmojiEvents, "Salvador - 100", secondary = true),
        Achievement(Icons.Default.Cancel, "Streak 30 Dias", unlocked = false),
        Achievement(Icons.Default.Recycling, "Zero Desperdício", unlocked = false),
        Achievement(Icons.Default.VolunteerActivism, "Multi-Doador", unlocked = false)
    )
    ProfileCard(modifier) {
        Column(Modifier.padding(16.dp)) {
            SectionTitle("Conquistas Desbloqueadas")
            Spacer(Modifier.height(12.dp))
            achievements.chunked(3).forEachIndexed { index, row ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { item ->
                        AchievementItem(item, Modifier.weight(1f))
                    }
                }
                if (index == 0) Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun AchievementItem(item: Achievement, modifier: Modifier = Modifier) {
    val accent = if (item.secondary) {
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.primary
    }
    Column(
        modifier = modifier.alpha(if (item.unlocked) 1f else 0.38f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(44.dp)
                .border(1.dp, accent, CircleShape),
            color = accent.copy(alpha = 0.08f),
            shape = CircleShape
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(item.icon, null, Modifier.size(25.dp), tint = accent)
            }
        }
        Text(
            item.label,
            modifier = Modifier.padding(top = 4.dp),
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            lineHeight = 12.sp,
            maxLines = 2
        )
    }
}

@Composable
private fun ProfileSettingsCard(
    onAccountSettingsClick: () -> Unit,
    onPickupHistoryClick: () -> Unit,
    onPrivacyPolicyClick: () -> Unit,
    onAboutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        SettingsItem("Configurações de Conta", onAccountSettingsClick),
        SettingsItem("Histórico de Retiradas", onPickupHistoryClick),
        SettingsItem("Políticas de Privacidade", onPrivacyPolicyClick),
        SettingsItem("Sobre o FoodRescue & ESG", onAboutClick)
    )
    ProfileCard(modifier) {
        Column(Modifier.padding(horizontal = 14.dp, vertical = 8.dp)) {
            items.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 36.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .clickable(role = Role.Button, onClick = item.onClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        item.label,
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                if (index < items.lastIndex) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outline)
                }
            }
        }
    }
}

@Composable
private fun ProfileBottomBar(
    onDestinationClick: (ProfileDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileNavigationItem(Icons.Default.Home, "Home", false, Modifier.weight(1f)) {
                onDestinationClick(ProfileDestination.HOME)
            }
            ProfileNavigationItem(Icons.Default.Search, "Explorar", false, Modifier.weight(1f)) {
                onDestinationClick(ProfileDestination.EXPLORE)
            }
            Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
                FloatingActionButton(
                    onClick = { onDestinationClick(ProfileDestination.ADD) },
                    modifier = Modifier.size(72.dp),
                    shape = RoundedCornerShape(14.dp),
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    elevation = FloatingActionButtonDefaults.elevation(0.dp)
                ) {
                    Icon(Icons.Default.Add, "Adicionar doação", Modifier.size(34.dp))
                }
            }
            ProfileNavigationItem(
                Icons.Outlined.FavoriteBorder,
                "Retiradas",
                false,
                Modifier.weight(1f)
            ) { onDestinationClick(ProfileDestination.PICKUPS) }
            ProfileNavigationItem(
                Icons.Outlined.AccountCircle,
                "Perfil",
                true,
                Modifier.weight(1f)
            ) { onDestinationClick(ProfileDestination.PROFILE) }
        }
    }
}

@Composable
private fun ProfileNavigationItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurfaceVariant
    Column(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(8.dp))
            .clickable(role = Role.Button, onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(icon, null, Modifier.size(28.dp), tint = color)
        Text(label, Modifier.padding(top = 2.dp), color = color, fontSize = 11.sp, maxLines = 1)
    }
}

@Composable
private fun ProfileCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) { content() }
}

@Composable
private fun ProfileTag(
    text: String,
    contentColor: Color,
    containerColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(modifier, shape = RoundedCornerShape(6.dp), color = containerColor) {
        Text(
            text,
            Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            color = contentColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
}

private data class ImpactMetric(
    val icon: ImageVector,
    val value: String,
    val label: String,
    val secondary: Boolean = false
)

private data class Achievement(
    val icon: ImageVector,
    val label: String,
    val unlocked: Boolean = true,
    val secondary: Boolean = false
)

private data class SettingsItem(val label: String, val onClick: () -> Unit)

@Preview(
    name = "Perfil claro",
    showBackground = true,
    widthDp = 412,
    heightDp = 915,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun ProfileScreenLightPreview() {
    FoodRescueTheme(darkTheme = false) { ProfileScreen() }
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
    FoodRescueTheme(darkTheme = true) { ProfileScreen() }
}
