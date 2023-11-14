package com.example.filmushits.view.screen.app_screen.ProfileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.R
import com.example.filmushits.view.screen.log_reg_screen.Auth.LogScreen.fillCheckerLog
import com.example.filmushits.view.screen.log_reg_screen.Auth.RegScreen.CustomRadioGroup
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.RadioButtonColor
import com.example.filmushits.view.theme.TextButtonLabel
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextFieldBorderColor
import com.example.filmushits.view.theme.TextLabel
import com.example.filmushits.view.theme.TextTitle1
import java.security.spec.EllipticCurve

@Composable
fun ProfileScreen() {
    val profileViewModel: ProfileViewModel = viewModel()
    var profileData by remember { mutableStateOf<ProfileModel?>(null) }
    var email by remember { mutableStateOf("")}
    var avatarLink by remember { mutableStateOf("")}
    var name by remember { mutableStateOf("")}
    var gender by remember { mutableStateOf(0)}
    var birthDate by remember { mutableStateOf("")}

    var selectedOption by rememberSaveable { mutableStateOf<String?>(
        if (gender == 0) "Мужчина"
        else "Женщина"
    ) }
    var selectedOptionSender by remember { mutableStateOf(0)}
    val options = listOf(stringResource(id = R.string.male), stringResource(id = R.string.female))
    var changeChecker by remember { mutableStateOf(false)}

    LaunchedEffect(Unit){
        profileData = profileViewModel.getProfile().await()
        email = profileData?.email ?: ""
        avatarLink = profileData?.avatarLink ?: ""
        gender = profileData?.gender ?: 0
        name = profileData?.name ?: ""
        birthDate = profileData?.birthDate ?: ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painter = rememberImagePainter(data = avatarLink,
                builder = {}
            )
            Image(painter = painter, contentDescription = "avatar",
                modifier = Modifier.clip(shape = CircleShape))
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextTitle1(text = name)
            }
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 12.dp, end = 15.dp, bottom = 12.dp),
                onClick = { /*TODO*/ }
            ) {
                TextButtonLabel(text = stringResource(id = R.string.logout))
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                TextLabel(text = stringResource(id = R.string.mail))

                OutlinedTextField(
                    value = email, onValueChange = {
                        email = it
                        changeChecker = true
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
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                TextLabel(text = stringResource(id = R.string.avalink))

                OutlinedTextField(
                    value = avatarLink, onValueChange = {
                        avatarLink = it
                        changeChecker = true
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
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                TextLabel(text = stringResource(id = R.string.name))

                OutlinedTextField(
                    value = name, onValueChange = {
                        name = it
                        changeChecker = true
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
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
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
                            changeChecker = true
                        }
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                TextLabel(text = stringResource(id = R.string.date_of_birth))

                OutlinedTextField(
                    value = birthDate, onValueChange = {
                        birthDate = it
                        changeChecker = true
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
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(
                if (changeChecker) 1f
                else 0.5f
            )
        ) {
            TextButton(
                onClick = {
                    /*if (changeChecker) {
                        val job = profileViewModel.putProfile()
                        job.invokeOnCompletion {
                            if (!job.isCancelled) navController.navigate("AppScreen")
                        }
                    }*/
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFFC315E),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(0.dp)

            ) {
                TextButtonLabel(text = stringResource(id = R.string.save))
            }
            TextButton(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    .background(
                        color = Color(0xFF292929),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
            ) {
                TextLabel(stringResource(R.string.cancel))
            }
        }
    }
}