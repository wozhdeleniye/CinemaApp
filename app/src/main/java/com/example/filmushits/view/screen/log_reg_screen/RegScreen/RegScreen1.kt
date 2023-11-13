package com.example.filmushits.view.screen.log_reg_screen.RegScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.filmushits.R
import com.example.filmushits.view.custom_function.CustomRadioGroup
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.BottomTextColor
import com.example.filmushits.view.theme.ButtonColor
import com.example.filmushits.view.theme.RadioButtonColor
import com.example.filmushits.view.theme.TextBottomText
import com.example.filmushits.view.theme.TextButtonLabel
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextFieldBorderColor
import com.example.filmushits.view.theme.TextLabel
import com.example.filmushits.view.theme.TextLogo
import com.example.filmushits.view.theme.TextTitle2


@Composable
fun RegScreen1(navController: NavHostController) {

    var name by rememberSaveable { mutableStateOf("") }
    var login by rememberSaveable { mutableStateOf("") }
    var mail by rememberSaveable { mutableStateOf("") }
    var dateOfBirth by rememberSaveable { mutableStateOf("") }

    var selectedOption by rememberSaveable { mutableStateOf<String?>("Мужчина") }
    val options = listOf(stringResource(id = R.string.male), stringResource(id = R.string.female))
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = BackGroundColor)
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
                        contentDescription = stringResource(id = R.string.image_description),
                        contentScale = ContentScale.None
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.34f),
                    verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextLogo(text = stringResource(id = R.string.logo), ButtonColor)
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
                TextTitle2(text = stringResource(id = R.string.registration))

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
                        TextLabel(text = stringResource(id = R.string.name))

                        OutlinedTextField(
                            value = name, onValueChange = { name = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = TextColor
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = TextFieldBorderColor,
                                unfocusedBorderColor = TextFieldBorderColor,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .background(
                                color = RadioButtonColor, shape = RoundedCornerShape(size = 8.dp)
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
                        TextLabel(text = stringResource(id = R.string.login))

                        OutlinedTextField(
                            value = login, onValueChange = { login = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = TextColor
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = TextFieldBorderColor,
                                unfocusedBorderColor = TextFieldBorderColor,
                            )
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        TextLabel(text = stringResource(id = R.string.mail))

                        OutlinedTextField(
                            value = mail, onValueChange = { mail = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = TextColor
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = TextFieldBorderColor,
                                unfocusedBorderColor = TextFieldBorderColor,
                            )
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        TextLabel(text = stringResource(id = R.string.date_of_birth))

                        OutlinedTextField(

                            trailingIcon = {
                                Icon(painter = painterResource(id = R.drawable.calendar),
                                    contentDescription = stringResource(id = R.string.image_description),
                                    modifier = Modifier.clickable {

                                    })
                            },
                            value = dateOfBirth, onValueChange = { dateOfBirth = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = TextColor
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = TextFieldBorderColor,
                                unfocusedBorderColor = TextFieldBorderColor,
                            )
                        )
                    }

                }
            }
            Box(
                modifier = Modifier.alpha(
                    if (fillCheckerReg1(name, login, mail)) 0.5f
                    else 1f
                )
            ) {
                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ButtonColor, shape = RoundedCornerShape(size = 10.dp))
                    .padding(0.dp), onClick = {
                    if (fillCheckerReg1(name, login, mail)) navController.navigate("RegScreen2")
                }) {
                    TextButtonLabel(text = stringResource(id = R.string.to_continue))
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(), Arrangement.Center
        ) {

            TextBottomText(text = stringResource(id = R.string.bottom_reg1) + " ", BottomTextColor)

            Row(modifier = Modifier.clickable { navController.navigate("LogScreen") }) {
                TextBottomText(text = stringResource(id = R.string.bottom_reg2), ButtonColor)
            }

        }
    }
}

fun fillCheckerReg1(
    name: String,
    login: String,
    mail: String
): Boolean {
    return (name != "") and (login != "") and (mail != "")
}