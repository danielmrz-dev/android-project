package br.com.fiap.foodrescue.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = GreenDark,
    secondary = OrangeDark,
)

private val LightColorScheme = lightColorScheme(
    primary = Green,
    onPrimary = White,

    primaryContainer = Cream,
    onPrimaryContainer = GreenDark,

    secondary = Orange,
    onSecondary = White,

    secondaryContainer = CreamLight,
    onSecondaryContainer = TextPrimary,

    tertiary = Terracotta,
    onTertiary = White,

    background = Cream,
    onBackground = TextPrimary,

    surface = White,
    onSurface = TextPrimary,

    surfaceVariant = CreamLight,
    onSurfaceVariant = TextSecondary,

    outline = Border,

    error = Terracotta,
    onError = White
)

@Composable
fun FoodRescueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}