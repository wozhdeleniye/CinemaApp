package com.example.filmushits.view.screen.app_screen.FavoriteScreen

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.filmushits.Etities.Models.MovieElementModel
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.R
import com.example.filmushits.view.screen.app_screen.ProfileScreen.ProfileViewModel
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.TextBottomText
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextTitle1

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FavoriteScreen(navHostController: NavHostController) {
    val favoriteViewModel: FavoriteViewModel = viewModel()
    val profileViewModel: ProfileViewModel = viewModel()

    var movies by remember { mutableStateOf<List<MovieElementModel>?>(null) }
    var profileData by remember { mutableStateOf<ProfileModel?>(null) }
    var userID by remember{ mutableStateOf("")}
    LaunchedEffect(Unit){
        movies = favoriteViewModel.getFavorite().await()?.movies ?: emptyList()
        profileData = profileViewModel.getProfile().await()
        userID = profileData?.id ?: ""
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
        Box(modifier = Modifier.fillMaxWidth()){
            TextTitle1(text = stringResource(id = R.string.liked))
        }

        FlowRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            maxItemsInEachRow = 2
        ) {
            if (movies != null && movies!!.isNotEmpty() && userID != ""){
                var itemNum: Int = 0
                movies!!.forEach { item ->
                    Column(Modifier.clickable {
                        navHostController.navigate("FilmScreen/${item.id}")
                    }) {
                        if ((itemNum + 1) % 3 == 0) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(244.dp),
                                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                                horizontalAlignment = Alignment.Start
                            ){
                                LikedItem(item, userID)
                            }
                        } else {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.45f)
                                    .height(244.dp),
                                verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
                                horizontalAlignment = Alignment.Start
                            ){
                                LikedItem(item, userID)
                            }
                        }
                    }
                    itemNum+=1
                }
            }

        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LikedItem(
    movie: MovieElementModel,
    id: String
){
    var ratingExist = false
    var rating = 10
    movie.reviews.forEach { it ->
        if(it.id == id){
            ratingExist = true
            rating = it.rating
        }
    }
    Column {
        Column(
            Modifier.padding(vertical = 5.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopEnd
            ){
                Column {
                    GlideImage(
                        model = movie.poster,
                        contentDescription = stringResource(id = R.string.image_description),
                        contentScale = ContentScale.FillWidth
                    )
                }
                if(ratingExist == true){
                    Column(
                        modifier = Modifier
                            .padding(end = 2.dp, top = 2.dp)
                            .background(
                                color = (
                                        if (rating >= 9) Color(0xFF4BB34B)
                                        else (
                                                if (rating >= 7) Color(0x10734922)
                                                else (
                                                        if ((rating >= 6)) Color(0xFFFFD54F)
                                                        else (
                                                                if (rating >= 3) Color(0xFFF05C44)
                                                                else Color(0x16722436)
                                                                )
                                                        )
                                                )
                                        ),
                                shape = RoundedCornerShape(size = 35.dp)
                            )
                            .padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 2.dp)
                    ){
                        Row() {
                            Image(painter = painterResource(id = R.drawable.star_rating), contentDescription = null)
                            Text(
                                text = rating.toString(),
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
            TextBottomText(text = movie.name, color = TextColor)
        }
    }
}