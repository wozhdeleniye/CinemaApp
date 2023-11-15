package com.example.filmushits.view.screen.log_reg_screen.Auth.RegScreen

import android.util.Log
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import com.example.filmushits.R
import com.example.filmushits.view.screen.log_reg_screen.Auth.AuthViewModel
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
    val regViewModel: AuthViewModel = viewModel()


    var name by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }

    var selectedOption by rememberSaveable { mutableStateOf<String?>("Мужчина") }
    var selectedOptionBody by remember { mutableStateOf(0)}

    var password by rememberSaveable { mutableStateOf("") }
    var passwordrepeat by rememberSaveable { mutableStateOf("") }



    var regStep by remember { mutableStateOf(false)}

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
            Column {
                topRegBar(navController)
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if(!regStep){
                    regFields1(
                        onValueChangeName = { namef -> name = namef },
                        onValueChangeS = { sf -> selectedOption = sf },
                        onValueChangeLogin = { loginf -> login = loginf },
                        onValueChangeMail = { mailf -> mail = mailf },
                        onValueChangeDOB = { dobf -> dateOfBirth = dobf }
                    )
                }
                else{
                    regFields2(
                        navController = navController,
                        onValueChangePass = {passf -> password = passf},
                        onValueChangePassR = {passrf -> passwordrepeat = passrf})
                }
            }

            Box(
                modifier = Modifier.alpha(
                    if ((fillCheckerReg1(name, login, mail, dateOfBirth) and !regStep) or (fillCheckerReg2(password, passwordrepeat) and regStep)) 1f
                    else 0.5f
                )
            ) {
                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = ButtonColor, shape = RoundedCornerShape(size = 10.dp))
                    .padding(0.dp), onClick = {
                        if (!regStep and fillCheckerReg1(name, login, mail, dateOfBirth)) regStep = true
                        if (regStep and fillCheckerReg2(password, passwordrepeat)) {
                            if (selectedOption == "Женщина") selectedOptionBody = 1
                            val job = regViewModel.register(RegisterRequestBody(name, login, password, mail, revertFormatDate(dateOfBirth), selectedOptionBody))
                            job.invokeOnCompletion {
                                if (!job.isCancelled) navController.navigate("AppScreen")
                            }
                        }
                }) {
                    if(!regStep) TextButtonLabel(text = stringResource( R.string.to_continue))
                    else TextButtonLabel(text = stringResource( R.string.to_register))
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

@Composable
fun regFields1(
    onValueChangeName: (String) -> Unit,
    onValueChangeS: (String) -> Unit,
    onValueChangeLogin: (String) -> Unit,
    onValueChangeMail: (String) -> Unit,
    onValueChangeDOB: (String) -> Unit
){

    var name by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }

    var selectedOption by remember { mutableStateOf<String?>("Мужчина") }
    val options = listOf(stringResource(id = R.string.male), stringResource(id = R.string.female))

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
                value = name, onValueChange = {
                    name = it
                    onValueChangeName(name)
                 },
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
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ){

            TextLabel(text = stringResource(id = R.string.sex))
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
                    onOptionSelected = {
                            option -> selectedOption = option
                        onValueChangeS(option)
                    }
                )
            }
        }


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            TextLabel(text = stringResource(id = R.string.login))

            OutlinedTextField(
                value = login, onValueChange = {
                    login = it
                    onValueChangeLogin(login)
                },
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
                value = mail, onValueChange = {
                    mail = it
                    onValueChangeMail(mail)
                },
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
                value = dateOfBirth, onValueChange = {
                    dateOfBirth = it
                    onValueChangeDOB(it)
                    },
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

@Composable
fun regFields2(
    navController: NavHostController,
    onValueChangePass: (String) -> Unit,
    onValueChangePassR: (String) -> Unit,
){
    var password by rememberSaveable { mutableStateOf("") }
    var passwordrepeat by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var passwordrepeatVisible by rememberSaveable { mutableStateOf(false) }

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
            TextLabel(text = stringResource(id = R.string.password))

            OutlinedTextField(
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.eye),
                        contentDescription = stringResource(id = R.string.image_description),
                        modifier = Modifier.clickable {
                            passwordVisible = !passwordVisible
                        })
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = password,
                onValueChange = {
                    password = it
                    onValueChangePass(it)
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
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            TextLabel(text = stringResource(id = R.string.repeat_password))

            OutlinedTextField(
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.eye),
                        contentDescription = stringResource(id = R.string.image_description),
                        modifier = Modifier.clickable {
                            passwordrepeatVisible = !passwordrepeatVisible
                        })
                },
                visualTransformation = if (passwordrepeatVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = passwordrepeat,
                onValueChange = {
                    passwordrepeat = it
                    onValueChangePassR(it)
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(
                    color = Color(0xFFFFFFFF)
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF5E5E5E),
                    unfocusedBorderColor = Color(0xFF5E5E5E),
                )
            )
        }
    }
}



@Composable
fun topRegBar(navController: NavHostController){
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
}





fun textColor(
    selected:Boolean
): Color {
    if(selected) return Color(0xFF404040)
    else return Color(0xFF909499)
}

@Composable
fun CustomRadioButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .padding(2.dp)
            .clickable(onClick = onClick)
            .fillMaxWidth(
                if (text == "Мужчина") 0.5f
                else 1f
            )
            .background(
                if (selected) Color(0xFFFFFFFF)
                else Color.Transparent,
                shape = RoundedCornerShape(size = 7.dp)
            ),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 8.dp, top = 11.dp, end = 8.dp, bottom = 11.dp),

            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(400),
                color = textColor(selected),
                textAlign = TextAlign.Center,
            )
        )
    }
}



@Composable
fun CustomRadioGroup(
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)

    ) {
        options.forEach { option ->
            CustomRadioButton(
                text = option,
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) }
            )
        }
    }
}


fun fillCheckerReg1(
    name: String,
    login: String,
    mail: String,
    dob: String
): Boolean {
    return checkIfLoginValid(login) && checkIfNameValid(name) && checkIfBirthDateValid(dob) && checkIfEmailValid(mail)
}

fun fillCheckerReg2(
    password: String, rpassword: String
): Boolean {
    return checkIfPasswordValid(password) && checkIfPasswordValid(rpassword) && checkIfPasswordEqualsRepeatedPassword(password, rpassword)
}

fun checkIfLoginValid(text: String): Boolean {
    return text.isNotEmpty()
}

fun checkIfNameValid(text: String): Boolean {
    return text.isNotEmpty()
}

fun checkIfPasswordValid(text: String): Boolean {
    return text.isNotEmpty()
}

fun checkIfBirthDateValid(text: String): Boolean {
    return Regex("""((([1-2][0-9]|3[0-1]|0[1-9]).(0[13-9]|1[0-2])|(0[13-9]|1[0-2]).([1-2][0-9]|3[0-1]|0[1-9])).\d{4})""").matches(text)
}

fun checkIfEmailValid(text: String): Boolean {
    return Regex("""^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+${'$'}""").matches(text)
}
fun revertFormatDate(date: String): String {
    val (day, month, year) = date.split('.')
    return "${year}-${month}-${day}T00:00:00"
}
fun checkIfPasswordEqualsRepeatedPassword(password: String, repeatedPassword: String): Boolean {
    return password == repeatedPassword
}

