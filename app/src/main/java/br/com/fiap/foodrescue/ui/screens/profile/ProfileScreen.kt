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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

private val ProfileLightColors = lightColorScheme(
    primary = Color(0xFF3D714B),
    onPrimary = Color.White,
    secondary = Color(0xFFFF773C),
    onSecondary = Color.White,
    background = Color(0xFFF4E9CE),
    surface = Color.White,
    surfaceVariant = Color.White,
    onSurface = Color(0xFF1D1B20),
    onSurfaceVariant = Color(0xFF8E8E93),
    outline = Color(0xFFDCEBE5),
    error = Color(0xFFD32F2F)
)

private val ProfileDarkColors = darkColorScheme(
    primary = Color(0xFF4DBD78),
    onPrimary = Color.White,
    secondary = Color(0xFFD9824A),
    onSecondary = Color.White,
    background = Color(0xFF1A1A1A),
    surface = Color(0xFF252525),
    surfaceVariant = Color(0xFF171A18),
    onSurface = Color(0xFFF7F7F7),
    onSurfaceVariant = Color(0xFFA7A7A7),
    outline = Color(0xFF214F30),
    error = Color(0xFFFF5C5C)
)

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onThemeClick: () -> Unit = {}
) {
    val colors = if (isSystemInDarkTheme()) ProfileDarkColors else ProfileLightColors

    MaterialTheme(colorScheme = colors, typography = MaterialTheme.typography) {
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
                    bottomBar = { ProfileBottomBar() }
                ) { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        contentPadding = PaddingValues(15.dp, 11.dp, 15.dp, 16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        item { ProfileHeader(onThemeClick) }
                        item { UserCard() }
                        item { ImpactCard() }
                        item { AchievementsCard() }
                        item { SettingsCard() }
                    }
                }
            }
        }
    }
}

// Cabeçalho da tela
@Composable
private fun ProfileHeader(onThemeClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
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
                    .clickable { }
                    .padding(horizontal = 10.dp, vertical = 2.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Localização",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(22.dp)
                )
                Column(modifier = Modifier.padding(start = 4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Localização", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 15.sp)
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(13.dp)
                        )
                    }
                    Text(
                        text = "Vila Madalena, SP",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            IconButton(onClick = onThemeClick, modifier = Modifier.size(38.dp)) {
                Icon(
                    imageVector = Icons.Default.Contrast,
                    contentDescription = "Alternar tema",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(22.dp)
                )
            }

            NotificationIcon()
        }

        Text(
            text = "Seu Perfil",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.56.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.outline)
    }
}

@Composable
private fun NotificationIcon() {
    Box(modifier = Modifier.size(38.dp)) {
        IconButton(onClick = { }, modifier = Modifier.size(38.dp)) {
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = "Notificações",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        Surface(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(18.dp),
            color = MaterialTheme.colorScheme.secondary,
            shape = CircleShape
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("3", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// Card com os dados da usuária
@Composable
private fun UserCard() {
    ProfileCard {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.profile_avatar),
                contentDescription = "Foto de Carol Silva",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    "Carol Silva",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    ProfileTag("Eco-Herói", MaterialTheme.colorScheme.primary)
                    ProfileTag("🔥 14 dias", MaterialTheme.colorScheme.secondary)
                }
            }
            TextButton(onClick = { }) {
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

// Card com os números de impacto ambiental
@Composable
private fun ImpactCard() {
    ProfileCard {
        Column(modifier = Modifier.padding(16.dp)) {
            SectionTitle("Seu Impacto Ambiental")
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ImpactItem(Icons.Default.Restaurant, "145", "Refeições Salvas", Modifier.weight(1f))
                ImpactItem(Icons.Default.Scale, "360 kg", "Alimentos Salvos", Modifier.weight(1f), true)
                ImpactItem(Icons.Default.Eco, "62 kg", "CO2 Evitado", Modifier.weight(1f))
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
            SectionTitle("Conquistas Desbloqueadas")
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AchievementItem(Icons.Default.Grain, "Mestre da Padaria", Modifier.weight(1f))
                AchievementItem(Icons.Default.Spa, "Guerreiro do Hortifruti", Modifier.weight(1f))
                AchievementItem(Icons.Default.EmojiEvents, "Salvador - 100", Modifier.weight(1f), orange = true)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AchievementItem(Icons.Default.Cancel, "Streak 30 Dias", Modifier.weight(1f), enabled = false)
                AchievementItem(Icons.Default.Recycling, "Zero Desperdício", Modifier.weight(1f), enabled = false)
                AchievementItem(Icons.Default.VolunteerActivism, "Multi-Doador", Modifier.weight(1f), enabled = false)
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
        "Configurações de Conta",
        "Histórico de Retiradas",
        "Políticas de Privacidade",
        "Sobre o FoodRescue & ESG"
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

// Barra inferior. A navegação será ligada junto com as rotas do aplicativo.
@Composable
private fun ProfileBottomBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
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
            BottomItem(Icons.Default.Home, "Home", Modifier.weight(1f))
            BottomItem(Icons.Default.Search, "Explorar", Modifier.weight(1f))

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                FloatingActionButton(
                    onClick = { },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(14.dp),
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(Icons.Default.Add, "Adicionar doação", Modifier.size(34.dp))
                }
            }

            BottomItem(Icons.Outlined.FavoriteBorder, "Retiradas", Modifier.weight(1f))
            BottomItem(Icons.Outlined.AccountCircle, "Perfil", Modifier.weight(1f), selected = true)
        }
    }
}

@Composable
private fun BottomItem(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    val color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant

    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable { },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(icon, label, Modifier.size(28.dp), tint = color)
        Text(label, color = color, fontSize = 11.sp, modifier = Modifier.padding(top = 2.dp))
    }
}

@Composable
private fun ProfileCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        content()
    }
}

@Composable
private fun ProfileTag(text: String, color: Color) {
    Surface(color = color.copy(alpha = 0.10f), shape = RoundedCornerShape(6.dp)) {
        Text(
            text,
            color = color,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
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
