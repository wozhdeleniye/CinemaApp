package com.example.filmushits.view.screen.app_screen.FilmScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.filmushits.Etities.Models.GenreModel
import com.example.filmushits.Etities.Models.MovieDetailsModel
import com.example.filmushits.Etities.Models.MovieElementModel
import com.example.filmushits.Etities.Models.MovieListModel
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.Models.ReviewModel
import com.example.filmushits.Etities.RequestBodies.LoginRequestBody
import com.example.filmushits.R
import com.example.filmushits.view.screen.app_screen.FavoriteScreen.FavoriteViewModel
import com.example.filmushits.view.theme.AboutItemString1
import com.example.filmushits.view.theme.AboutItemString2
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.ButtonColor
import com.example.filmushits.view.theme.GenreItemText
import com.example.filmushits.view.theme.TextBottomText
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextDescription
import com.example.filmushits.view.theme.TextFilmGenre
import com.example.filmushits.view.theme.TextLogo
import com.example.filmushits.view.theme.TextTitle1

@OptIn(ExperimentalLayoutApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun FilmScreen(navHostController: NavHostController, id: String) {
    val filmViewModel: FilmViewModel = viewModel()
    val favoriteViewModel: FavoriteViewModel = viewModel()

    var filmData by remember { mutableStateOf<MovieDetailsModel?>(null) }
    var favoriteList by remember { mutableStateOf<List<MovieElementModel>?>(null)}

    var name by remember { mutableStateOf("")}
    var poster by remember { mutableStateOf("")}
    var year by remember { mutableStateOf(0)}
    var country by remember { mutableStateOf("")}
    var time by remember { mutableStateOf(0)}
    var tagline by remember { mutableStateOf("")}
    var description by remember { mutableStateOf("")}
    var director by remember { mutableStateOf("")}
    var budget by remember { mutableStateOf(0)}
    var fees by remember { mutableStateOf(0)}
    var agelimit by remember { mutableStateOf(0)}
    var genres by remember { mutableStateOf<List<GenreModel>?>(emptyList())}
    var reviews by remember { mutableStateOf<List<ReviewModel>?>(emptyList())}

    LaunchedEffect(Unit){
        filmData = filmViewModel.getDetails(id).await()
        favoriteList = favoriteViewModel.getFavorite().await()?.movies ?: emptyList()
        name = filmData?.name ?: ""
        poster = filmData?.poster ?: ""
        year = filmData?.year ?: 0
        country = filmData?.country ?: ""
        time = filmData?.time ?: 0
        tagline = filmData?.tagline ?: ""
        description = filmData?.description ?: ""
        director = filmData?.director ?: ""
        budget = filmData?.budget ?: 0
        fees = filmData?.fees ?: 0
        agelimit = filmData?.ageLimit ?: 0
        genres = filmData?.genres ?: emptyList()
        reviews = filmData?.reviews ?: emptyList()
    }

    var favorite = false

    var rating = 0.0
    if(filmData != null && favoriteList != null){
        reviews!!.forEach { it ->
            rating += it.rating
        }
        rating /= reviews!!.size


        Column(
            Modifier
                .fillMaxSize()
                .background(BackGroundColor)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .verticalScroll(rememberScrollState())
            ){
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 10.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .padding(1.dp)
                            .fillMaxWidth(0.33f)
                            .clickable(onClick = {
                                navHostController.navigate("main_screen")
                            }),
                        painter = painterResource(id = R.drawable.go_back_vector),
                        contentDescription = stringResource(id = R.string.image_description),
                        contentScale = ContentScale.None
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(0.34f),
                        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        TextLogo(text = stringResource(id = R.string.logo), BackGroundColor)
                    }
                    Column(modifier = Modifier
                        .padding(1.dp)
                        .fillMaxWidth(0.33f)
                    ) {

                    }
                }

                Box(contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    GlideImage(
                        model = poster,
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row (
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column() {
                            if(rating>0){
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier

                                        .background(
                                            color = (
                                                    if (rating >= 9) Color(0xFF4BB34B)
                                                    else (
                                                            if (rating >= 7) Color(0xFFA3CD4A)
                                                            else (
                                                                    if ((rating >= 6)) Color(
                                                                        0xFFFFD54F
                                                                    )
                                                                    else (
                                                                            if (rating >= 3) Color(
                                                                                0xFFF05C44
                                                                            )
                                                                            else Color(0x16722436)
                                                                            )
                                                                    )
                                                            )
                                                    ),
                                            shape = RoundedCornerShape(size = 5.dp)
                                        )
                                        .padding(
                                            start = 14.dp,
                                            top = 4.dp,
                                            end = 14.dp,
                                            bottom = 4.dp
                                        )
                                ) {
                                    Column() {
                                        Text(
                                            text = String.format("%.1f", rating),
                                            style = TextStyle(
                                                fontSize = 13.sp,
                                                fontFamily = FontFamily(Font(R.font.inter)),
                                                fontWeight = FontWeight(700),
                                                color = Color(0xFF1D1D1D),
                                            )
                                        )
                                    }
                                }
                            }
                        }

                        Column(modifier = Modifier.fillMaxWidth(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
                            TextTitle1(text = name)
                        }
                        Column() {
                            Column(modifier = Modifier
                                .background(
                                    color = Color(0xFF404040),
                                    shape = RoundedCornerShape(size = 50.dp)
                                )
                                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
                                .clickable {
                                    if (favorite) {
                                        val job = favoriteViewModel.deleteFavorite(filmData!!.id)
                                        job.invokeOnCompletion {
                                            favorite = false

                                        }
                                    } else {
                                        val job = favoriteViewModel.addFavorite(filmData!!.id)
                                        job.invokeOnCompletion {
                                            favorite = true
                                        }
                                    }
                                }
                            ) {
                                Icon(painter = ( if (favorite == false) painterResource(id = R.drawable.like_icon)
                                        else painterResource(id = R.drawable.like_pressed_icon)), contentDescription = null)
                            }
                        }

                    }
                    Column() {
                        TextDescription(text = description)
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        TextFilmGenre(text = "Жанры")
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
                        ) {
                            genres!!.forEach { it ->
                                GenreItem(it.name)
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        TextFilmGenre(text = "О фильме")

                        AboutItem(text = "Год", year.toString())
                        AboutItem(text = "Страна", country)
                        AboutItem(text = "Слоган", tagline)
                        AboutItem(text = "Режиссер", director)
                        AboutItem(text = "Бюджет", "$ " + budget.toString() )
                        AboutItem(text = "Сборы в мире", "$ " + fees.toString() )
                        AboutItem(text = "Возраст", agelimit.toString() +"+"  )
                        AboutItem(text = "Время", time.toString())
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row (
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            TextFilmGenre(text = "Отзывы")
                        }

                        Column(
                            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                            horizontalAlignment = Alignment.Start
                        ) {
                            reviews!!.forEach {it ->
                                ReviewItem(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ReviewItem(review: ReviewModel){
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(review.isAnonymous){
                GlideImage(
                    model = "https://static.vecteezy.com/system/resources/thumbnails/002/318/271/small/user-profile-icon-free-vector.jpg",
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape)
                        .width(40.dp)
                        .height(40.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start
                ) {

                    TextBottomText(text = "Анонимный пользователь", color = TextColor)
                }
            }
            else{
                GlideImage(
                    model = review.author.avatar,
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape)
                        .width(40.dp)
                        .height(40.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start
                ) {
                    TextBottomText(text = review.author.nickName, color = TextColor)
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            TextDescription(text = review.reviewText)
            Text(
                text = review.createDateTime,
                // 12 M Label
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF909499)
                )
            )
        }
    }
}
@Composable
fun GenreItem(text: String){
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

@Composable
fun AboutItem(text: String, text1: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.fillMaxWidth(0.3f)) {
            AboutItemString1(text = text)
        }
        Column(Modifier.fillMaxWidth(0.6f)) {
            AboutItemString2(text = text1)
        }
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

