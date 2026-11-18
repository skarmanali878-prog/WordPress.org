package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val HerFindsLightColorScheme = lightColorScheme(
    primary = BerryRose,
    onPrimary = Color.White,
    primaryContainer = BlushTint,
    onPrimaryContainer = BerryRosePressed,
    secondary = ForestGreen,
    onSecondary = Color.White,
    secondaryContainer = ForestGreenTint,
    onSecondaryContainer = ForestGreenDark,
    tertiary = BerryRoseSoft,
    onTertiary = Color.White,
    tertiaryContainer = BlushCardTile,
    onTertiaryContainer = EspressoInk,
    background = IvoryCream,
    onBackground = EspressoInk,
    surface = WarmWhite,
    onSurface = EspressoInk,
    surfaceVariant = BlushSurface,
    onSurfaceVariant = MutedPlum,
    outline = HairlineRose,
    outlineVariant = SoftStone
)

private val HerFindsDarkColorScheme = darkColorScheme(
    primary = DarkBerryRose,
    onPrimary = Color(0xFF470020),
    primaryContainer = DarkBlushCard,
    onPrimaryContainer = Color(0xFFFFD8E4),
    secondary = DarkForestGreen,
    onSecondary = Color(0xFF00391B),
    secondaryContainer = ForestGreen,
    onSecondaryContainer = ForestGreenTint,
    tertiary = BlushCardTile,
    onTertiary = EspressoInk,
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceMuted,
    outline = Color(0xFF4B3A40),
    outlineVariant = Color(0xFF33272B)
)

val HerFindsShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun HerFindsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) HerFindsDarkColorScheme else HerFindsLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = HerFindsTypography,
        shapes = HerFindsShapes,
        content = content
    )
}
