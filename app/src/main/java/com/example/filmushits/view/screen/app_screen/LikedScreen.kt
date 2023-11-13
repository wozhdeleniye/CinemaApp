package com.example.filmushits.view.screen.app_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.filmushits.R
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.TextBottomText
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextTitle1

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LikedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            TextTitle1(text = stringResource(id = R.string.liked))
        }

        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            maxItemsInEachRow = 2
        ) {
            val itemModifier = Modifier
                .padding(4.dp)
                .height(80.dp)
            repeat(6) { item ->
                // if the item is the third item, don't use weight modifier, but rather fillMaxWidth
                if ((item + 1) % 3 == 0) {
                    Column(
                        modifier = itemModifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ){}
                } else {
                    Column(
                        modifier = itemModifier.fillMaxWidth(0.5f),
                        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ){}
                }
            }
        }
    }
}

@Composable
fun LikedItem(){
    Column {
        Box(){

        }
        TextBottomText(text = "По соображениям совести", color = TextColor)
    }
}