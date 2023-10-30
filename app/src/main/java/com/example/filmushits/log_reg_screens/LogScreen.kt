package com.example.filmushits.log_reg_screens

import android.text.style.ClickableSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.filmushits.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogScreen(navController: NavHostController) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color(0xFF1D1D1D))
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.1f),

                    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(

                        modifier = Modifier
                            .padding(1.dp)
                            .clickable(onClick = {
                                navController.navigate("LogRegScreen")
                            }),
                        painter = painterResource(id = R.drawable.go_back_vector),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.34f),
                    verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "FИЛЬМУС",

                        // 17 SB Label
                        style = TextStyle(
                            fontSize = 17.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFC315E),

                            )
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(0.1f),
                    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Вход",
                    // 20 B Title 2
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            text = "Логин", style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                textAlign = TextAlign.Center,
                            )
                        )

                        OutlinedTextField(
                            value = username, onValueChange = { username = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = Color(0xFFFFFFFF)
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5E5E5E),
                                unfocusedBorderColor = Color(0xFF5E5E5E),
                            )

                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(

                            text = "Пароль",
                            // 15 M Label
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                textAlign = TextAlign.Center,
                            )
                        )

                        OutlinedTextField(
                            trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = "",
                                modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                            ) },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            value = password, onValueChange = { password = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = Color(0xFFFFFFFF)
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF5E5E5E),
                                unfocusedBorderColor = Color(0xFF5E5E5E),
                            )
                        )
                    }


                }
            }
            TextButton(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFC315E), shape = RoundedCornerShape(size = 10.dp))
                .padding(0.dp), onClick = {
                navController.navigate("LogRegScreen")
            }) {
                Text(
                    modifier = Modifier.padding(0.dp), text = "Войти",

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
        }

        Row(
            modifier = Modifier.fillMaxWidth(), Arrangement.Center
        ) {
            Text(
                text = "Еще нет аккаунта? ",
                // 14 M Label
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFC4C8CC),

                    textAlign = TextAlign.Center,
                )
            )
            Text(
                modifier = Modifier.clickable { navController.navigate("RegScreen1") },
                text = "Зарегистрируйтесь",
                // 14 M Label
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color("#FC315E".toColorInt()),

                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}