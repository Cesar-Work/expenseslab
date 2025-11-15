package com.example.expenseslab

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = Color(0xFF00C4FF),
    onPrimary = Color.Black,
    background = Color(0xFF050816),
    onBackground = Color.White,
    surface = Color(0xFF0B1020),
    onSurface = Color.White
)

@Composable
fun ExpensesLabTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = MaterialTheme.typography,
        content = content
    )
}
