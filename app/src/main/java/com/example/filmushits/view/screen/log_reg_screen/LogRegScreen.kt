package com.example.filmushits.view.screen.log_reg_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.filmushits.R
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.TextButtonLabel
import com.example.filmushits.view.theme.TextLabel
import com.example.filmushits.view.theme.TextLogo
import com.example.filmushits.view.theme.TextText
import com.example.filmushits.view.theme.TextTitle2

@Composable
fun LogRegScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .background(color = BackGroundColor)
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
                TextLogo(text = stringResource(R.string.logo), BackGroundColor)
            }

            Image(
                modifier = Modifier
                    .padding(0.dp),
                painter = painterResource(id = R.drawable.logreg_logo),
                contentDescription = stringResource(id = R.string.image_description),
                contentScale = ContentScale.None
            )


            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                TextTitle2(stringResource(id = R.string.logreg_label))

                TextText(stringResource(id = R.string.logreg_text))
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
                    TextButtonLabel(text = stringResource(id = R.string.registration))
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
                    TextLabel(stringResource(R.string.to_enter))
                }
            }
        }
    }
}
