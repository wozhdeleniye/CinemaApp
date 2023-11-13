package com.example.filmushits.view.screen.app_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.filmushits.R
import com.example.filmushits.view.theme.AboutItemString1
import com.example.filmushits.view.theme.AboutItemString2
import com.example.filmushits.view.theme.ButtonColor
import com.example.filmushits.view.theme.GenreBackground
import com.example.filmushits.view.theme.GenreItemText
import com.example.filmushits.view.theme.TextFilmGenre
import com.example.filmushits.view.theme.TextLogo

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilmScreen() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(0.1f),

            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(

                modifier = Modifier
                    .padding(1.dp)
                    .clickable(onClick = {

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
            modifier = Modifier
                .background(color = Color(0xFF404040), shape = RoundedCornerShape(size = 50.dp))
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(

                modifier = Modifier
                    .padding(1.dp)
                    .clickable(onClick = {

                    }),
                painter = painterResource(id = R.drawable.go_back_vector),
                contentDescription = stringResource(id = R.string.image_description),
                contentScale = ContentScale.None
            )
        }
    }
    Column {
        Image(
            painter = painterResource(R.drawable.test_film_banner),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
            Column(
                modifier = Modifier.fillMaxWidth(0.34f),
                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextLogo(text = stringResource(id = R.string.logo), ButtonColor)
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End),
                verticalAlignment = Alignment.CenterVertically
            ) {

            }
        }


        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            TextFilmGenre(text = stringResource(id = R.string.genres))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top)
            ) {
                val GenreList = arrayOf("драма","комедия","криминал", "ужастик")
                GenreList.forEach {
                    GenreItem(it)
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            TextFilmGenre(text = stringResource(id = R.string.about))

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                AboutItem(text = "Год")
                AboutItem(text = "Страна")
                AboutItem(text = "Слоган")
                AboutItem(text = "Режиссер")
                AboutItem(text = "Бюджет")
                AboutItem(text = "Сборы в мире")
                AboutItem(text = "Возраст")
                AboutItem(text = "Время")
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ){
                TextFilmGenre(text = stringResource(id = R.string.reviews))

                Column {
                }
            }

            Column {
                ReviewItem()
            }
        }
    }
}

@Composable
fun ReviewItem(){

}

@Composable
fun AboutItem(text: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.Top
    ) {
        AboutItemString1(text = text)

        AboutItemString2(text = "1111")
    }
}

@Composable
fun FilmScreenGenreItem(text: String){
    Column(
        modifier = Modifier
            .background(color = ButtonColor, shape = RoundedCornerShape(size = 5.dp))
            .padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 2.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GenreItemText(text = text)
    }
}

