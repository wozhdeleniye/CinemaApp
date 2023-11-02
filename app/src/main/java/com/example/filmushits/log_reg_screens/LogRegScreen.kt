package com.example.filmushits.log_reg_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.filmushits.R

@Composable
fun LogRegScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .background(color = Color(0xFF1D1D1D))
            .fillMaxSize()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(35.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "FИЛЬМУС",
                    color = Color(0xFF1D1D1D)
                )

            }

            Image(
                modifier = Modifier
                    .padding(0.dp),
                painter = painterResource(id = R.drawable.logreg_logo),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )


            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Погрузись в мир кино",

                    // 20 B Title 2
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Мы предлагаем удобный и легкий способ насладиться любимыми фильмами прямо с Вашего мобильного устройства.",

                    // 15 R Text
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }


            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextButton(
                    onClick = {
                        navController.navigate("RegScreen1")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFFC315E),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(0.dp)
                ) {
                    Text(
                        text = "Регистрация",

                        // 15 SB Label
                        style = TextStyle(

                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),

                            textAlign = TextAlign.Center,
                        )
                    )
                }

                TextButton(
                    onClick = {
                        navController.navigate("LogScreen")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                        .background(
                            color = Color(0xFF292929),
                            shape = RoundedCornerShape(size = 10.dp)
                        )


                ) {
                    Text(
                        text = "Войти",

                        // 15 SB Label
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFC315E),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}
