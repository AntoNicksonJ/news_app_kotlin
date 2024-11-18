package com.example.newsheadlines.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define custom colors
private val DarkColorPalette = darkColors(
    primary = Color(0xFF1A237E), // Dark blue color
    primaryVariant = Color(0xFF0D47A1), // Darker blue
    secondary = Color(0xFF64B5F6), // Light blue
    background = Color(0xFF212121), // Dark background
    surface = Color(0xFF424242), // Dark surface
    onPrimary = Color.White, // Text color on primary color
    onSecondary = Color.Black, // Text color on secondary color
    onBackground = Color.White, // Text color on background
    onSurface = Color.White // Text color on surface
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF3F51B5), // Light blue color
    primaryVariant = Color(0xFF1A237E), // Dark blue
    secondary = Color(0xFF64B5F6), // Light blue
    background = Color(0xFFF5F5F5), // Light background
    surface = Color.White, // White surface
    onPrimary = Color.White, // Text color on primary
    onSecondary = Color.Black, // Text color on secondary
    onBackground = Color.Black, // Text color on background
    onSurface = Color.Black // Text color on surface
)

@Composable
fun NewsHeadlinesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Choose the colors based on the theme (dark or light)
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // Apply the theme with custom colors
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
