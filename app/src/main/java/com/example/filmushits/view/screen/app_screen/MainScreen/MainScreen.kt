package com.example.filmushits.view.screen.app_screen.MainScreen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.filmushits.Etities.Models.MovieDetailsModel
import com.example.filmushits.Etities.Models.MovieElementModel
import com.example.filmushits.Etities.Models.MoviesPagedListModel
import com.example.filmushits.Etities.Models.PageInfoModel
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Etities.Models.ReviewModel
import com.example.filmushits.Etities.Models.UserShortModel
import com.example.filmushits.R
import com.example.filmushits.view.screen.app_screen.FilmScreen.FilmViewModel
import com.example.filmushits.view.screen.app_screen.ProfileScreen.ProfileViewModel
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.GenreBackground
import com.example.filmushits.view.theme.GenreItemText
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextTitle1

@Composable
fun MainScreen(navHostController: NavHostController) {

    val mainViewModel: MainViewModel = viewModel()
    val profileViewModel: ProfileViewModel = viewModel()


    var mainData by remember { mutableStateOf<MoviesPagedListModel?>(null) }
    var pageInfo by remember { mutableStateOf<PageInfoModel?>(null) }
    var movies by remember { mutableStateOf<List<MovieElementModel>?>(null)}

    var profileData by remember { mutableStateOf<ProfileModel?>(null) }
    var userID by remember{ mutableStateOf("")}

    LaunchedEffect(Unit){
        movies = mainViewModel.getMovies(1).await()?.movies ?: emptyList()
        profileData = profileViewModel.getProfile().await()
        userID = profileData?.id ?: ""
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
            .verticalScroll(rememberScrollState())
            .padding(0.dp)
    ) {
        if (movies != null && movies!!.isNotEmpty()){
            Box(modifier = Modifier.fillMaxWidth()){
                CarouselImages(movies!!)
            }
            Catalog(movies!!, navHostController, userID)
        }
    }
}

@Composable
fun CarouselImages(posterList: List<MovieElementModel>) {
    val posterListSliced = posterList.slice(0..3)
    Carousel(images = posterListSliced)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageItem(imageRes: String){
    GlideImage(
        model = imageRes,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(images: List<MovieElementModel>){
    val pageCount = images.size

    val state = rememberPagerState { pageCount }

    Box(contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
        .fillMaxWidth()
    ){
        HorizontalPager(
            state = state,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            ImageItem(imageRes = images[page].poster)
        }

        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .background(color = Color(0x1AFFFFFF), shape = RoundedCornerShape(size = 28.dp))
                    .padding(8.dp)
            ){
                repeat(pageCount){iteration ->
                    val dot = if (state.currentPage == iteration) R.drawable.filled_dot else R.drawable.empty_dot
                    Image(
                        painter = painterResource(dot),
                        contentDescription = stringResource(id = R.string.image_description),
                        contentScale = ContentScale.None
                    )
                }
            }
        }
    }


}


@Composable
fun Catalog(filmList: List<MovieElementModel>, navController: NavHostController, id: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Bottom),
        horizontalAlignment = Alignment.Start,
    ) {
        TextTitle1(text = stringResource(id = R.string.catalog))


        filmList.forEach { movieElementItem ->
            Column(Modifier.clickable { }) {
                FilmBanner(movieElementItem, navController, id)
            }
        }

    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun FilmBanner(movie: MovieElementModel, navController: NavHostController, id: String) {
    var urRating = 0
    val movieid = movie.id
    val detailViewModel: FilmViewModel = viewModel()
    var movieData by remember { mutableStateOf<MovieDetailsModel?>(null) }
    var reviewDetailed by remember { mutableStateOf<List<ReviewModel>?>(null)}
    LaunchedEffect(Unit){
        reviewDetailed = detailViewModel.getDetails(movieid).await()?.reviews ?: emptyList()
    }

    /*if (reviewDetailed != null && reviewDetailed!!.isNotEmpty()){
        reviewDetailed!!.forEach { it ->
            val athr = it.author
            if (athr.userId == id){
                urRating = it.rating
            }
        }
    }*/

    var rating: Double = 0.0
    movie.reviews.forEach {it->
        rating += it.rating
    }
    var revCount = movie.reviews.size



    rating = rating/revCount
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.clickable {
            navController.navigate("FilmScreen/${movie.id}")
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .width(95.dp)
                    .height(130.dp)
                    .padding(),
                contentAlignment = Alignment.TopStart
            ) {
                GlideImage(
                    model = movie.poster,
                    contentDescription = stringResource(id = R.string.image_description),
                    contentScale = ContentScale.FillBounds
                )
                if(revCount!= 0){
                    Column(
                        modifier = Modifier
                            .padding(top = 2.dp, start = 2.dp)
                            .background(
                                color = (
                                        if (rating >= 9) Color(0xFF4BB34B)
                                        else (
                                                if (rating >= 7) Color(0xFFA3CD4A)
                                                else (
                                                        if ((rating >= 6)) Color(0xFFFFD54F)
                                                        else (
                                                                if (rating >= 3) Color(0xFFF05C44)
                                                                else Color(0x16722436)
                                                                )
                                                        )
                                                )
                                        ),
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 2.dp)
                    ){
                        Column() {
                            Text(
                                text = String.format("%.1f",rating),
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

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = movie.name,

                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(700),
                                color = TextColor
                            )
                        )

                        if(urRating != 0){
                            Column(
                                modifier = Modifier
                                    .background(
                                        color = (
                                                if (urRating >= 9) Color(0xFF4BB34B)
                                                else (
                                                        if (urRating >= 7) Color(0xFFA3CD4A)
                                                        else (
                                                                if ((urRating >= 6)) Color(0xFFFFD54F)
                                                                else (
                                                                        if (urRating >= 3) Color(0xFFF05C44)
                                                                        else Color(0x16722436)
                                                                        )
                                                                )
                                                        )
                                                ),
                                        shape = RoundedCornerShape(size = 35.dp)
                                    )
                            ){
                                Row(
                                    modifier = Modifier.padding(4.dp),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(painter = painterResource(id = R.drawable.star_rating), contentDescription = null)
                                    Text(
                                        text = urRating.toString(),
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontFamily = FontFamily(Font(R.font.inter)),
                                            fontWeight = FontWeight(700),
                                            color = Color(0xFFFFFFFF),
                                        )
                                    )
                                }
                            }
                        }
                    }
                    Text(
                        text = "${movie.year} · ${movie.country}", style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(400),
                            color = TextColor
                        )
                    )
                }

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
                ) {
                    val genreList = movie.genres
                    genreList.forEach {
                        GenreItem(it.name)
                    }
                }
            }
        }
    }
}

@Composable
fun GenreItem(text: String){
    Column(
        modifier = Modifier
            .background(color = GenreBackground, shape = RoundedCornerShape(size = 5.dp))
            .padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 2.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GenreItemText(text = text)
    }
}