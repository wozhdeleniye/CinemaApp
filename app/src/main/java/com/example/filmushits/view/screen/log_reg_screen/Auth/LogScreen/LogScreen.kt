package com.example.filmushits.view.screen.log_reg_screen.Auth.LogScreen

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.R
import com.example.filmushits.view.screen.log_reg_screen.Auth.AuthViewModel
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.BottomTextColor
import com.example.filmushits.view.theme.ButtonColor
import com.example.filmushits.view.theme.TextBottomText
import com.example.filmushits.view.theme.TextButtonLabel
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextFieldBorderColor
import com.example.filmushits.view.theme.TextLabel
import com.example.filmushits.view.theme.TextLogo
import com.example.filmushits.view.theme.TextTitle2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogScreen(navController: NavHostController) {
    val loginViewModel: AuthViewModel = viewModel()
    //var loginData by remember{ mutableStateOf<LoginRequestBody?>(null) }

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = BackGroundColor)
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
                        contentDescription = stringResource(id = R.string.image_description),
                        contentScale = ContentScale.None
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.34f),
                    verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextLogo(text = stringResource(R.string.logo), ButtonColor)
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
                TextTitle2(text = stringResource(R.string.sign_in))

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
                        TextLabel(text = stringResource(R.string.login))

                        OutlinedTextField(
                            value = username,
                            onValueChange = {
                                username = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            textStyle = TextStyle(
                                color = TextColor
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = TextFieldBorderColor,
                                unfocusedBorderColor = TextFieldBorderColor
                            )

                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        TextLabel(text = stringResource(R.string.password))

                        OutlinedTextField(
                            trailingIcon = {
                                Icon(painter = painterResource(id = R.drawable.eye),
                                    contentDescription = "",
                                    modifier = Modifier.clickable {
                                        passwordVisible = !passwordVisible
                                    }
                                )
                            },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            value = password,
                            onValueChange = {
                                password = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
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
                    if (fillCheckerLog(username, password)) 1f
                    else 0.5f
                )
            ) {
                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ButtonColor, shape = RoundedCornerShape(size = 10.dp))
                    .padding(0.dp),
                    onClick = {
                        if (fillCheckerLog(username, password)) {
                            val job = loginViewModel.login(LoginRequestBody(username, password))
                            job.invokeOnCompletion {
                                if (!job.isCancelled) navController.navigate("AppScreen")
                            }
                        }
                    }
                ){
                    TextButtonLabel(text = stringResource(R.string.to_enter))
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(), Arrangement.Center
        ) {

            TextBottomText(text = stringResource(id = R.string.bottom_log1) + " ", BottomTextColor)

            Row(modifier = Modifier.clickable { navController.navigate("RegScreen1") }) {
                TextBottomText(text = stringResource(id = R.string.bottom_log2), ButtonColor)
            }

        }
    }
}
fun fillCheckerLog(
    username: String, password: String
): Boolean {
    return (username != "") and (password != "")
}