package com.film.guide.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val h1 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.W700, color = textDark)
val h2 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W600, color = textDarkGray)
val title = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500, color = textGray)
val p = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W600, color = textDark)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)