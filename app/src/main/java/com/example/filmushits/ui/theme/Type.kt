package com.example.filmushits.view.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.filmushits.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

@Composable
fun TextLabel(text: String){
    Text(
        text = text,
        // 15 M Label
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(500),
            color = TextColor,

            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextText(text: String){
    Text(
        text = text,
        // 15 R Text
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            color = TextColor,

            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextButtonLabel(text: String){
    Text(
        text = text,
        // 15 SB Label
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(600),
            color = TextColor,

            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextTitle1(text: String){
    Text(
        text = text,
        // 24 B Title 1
        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(700),
            color = TextColor,

            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextTitle2(text: String){
    Text(
        text = text,
        // 20 B Title 2
        style = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(700),
            color = TextColor,

            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextBottomText(text: String, color: Color){
    Text(
        text = text,
        // 14 M Label
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(500),
            color = color,

            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun TextLogo(text: String, color: Color){
    Text(
        text = text,

        // 17 SB Label
        style = TextStyle(
            fontSize = 17.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(600),
            color = color
        )
    )
}

@Composable
fun GenreItemText(text: String){
    Text(
        text = text,
        style = TextStyle(
            fontSize = 13.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            color = TextColor,

            textAlign = TextAlign.Center,
        )
    )
}
@Composable
fun TextFilmGenre(text: String){
    Text(
        text = text,
        // 16 B Label
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(700),
            color = Color(0xFFFFFFFF),

            )
    )
}
@Composable
fun AboutItemString1(text: String){
    Text(
        text = text,
        // 14 R Text
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            color = Color(0xFF909499)
        )
    )
}
@Composable
fun AboutItemString2(text: String){
    Text(
        text = "США, Австралия",
        // 14 R Text
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(400),
            color = Color(0xFFFFFFFF),

            )
    )
}


