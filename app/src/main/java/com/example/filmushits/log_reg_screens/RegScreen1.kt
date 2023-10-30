package com.example.filmushits.log_reg_screens

import android.util.Log
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
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmushits.R
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.filmushits.custom_function.Calendar
import com.example.filmushits.custom_function.CustomRadioGroup
import com.example.filmushits.custom_function.RadioButtonWithoutCircle
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegScreen1(navController: NavHostController) {

    var name by rememberSaveable { mutableStateOf("") }
    var login by rememberSaveable { mutableStateOf("") }
    var mail by rememberSaveable { mutableStateOf("") }
    var dateOfBirth by rememberSaveable { mutableStateOf("") }

    var selectedOption by rememberSaveable { mutableStateOf<String?>("Мужчина") }
    val options = listOf("Мужчина", "Женщина")

    val calendarState = UseCaseState()

    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true,
            style = CalendarStyle.MONTH
        ),
        selection = CalendarSelection.Date {date ->
            Log.d("SelectedDate", "$date")
        }
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color(0xFF1D1D1D))
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
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
                    text = "Регистрация",
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
                            text = "Имя", style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                textAlign = TextAlign.Center,
                            )
                        )

                        OutlinedTextField(
                            value = name, onValueChange = { name = it },
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .background(
                                color = Color(0x1F767680), shape = RoundedCornerShape(size = 8.dp)
                            )
                    ) {
                        CustomRadioGroup(
                            options = options,
                            selectedOption = selectedOption,
                            onOptionSelected = { option -> selectedOption = option }
                        )
                    }
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
                            value = login, onValueChange = { login = it },
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
                            text = "Электронная почта", style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                textAlign = TextAlign.Center,
                            )
                        )

                        OutlinedTextField(
                            value = mail, onValueChange = { mail = it },
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
                            text = "Дата рождения", style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                textAlign = TextAlign.Center,
                            )
                        )
                        OutlinedTextField(

                            trailingIcon = {
                                Icon(painter = painterResource(id = R.drawable.calendar), contentDescription = "",
                                    modifier = Modifier.clickable {
                                        calendarState.show()
                                    })
                            },
                            value = dateOfBirth, onValueChange = { dateOfBirth = it },
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
                navController.navigate("RegScreen2")
                }) {
                Text(
                    modifier = Modifier.padding(0.dp), text = "Продолжить",

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
        Row(modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            Text(
                text = "Уже есть аккаунт? ",
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
                modifier = Modifier.clickable { navController.navigate("LogScreen") },
                text = "Войдите",
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