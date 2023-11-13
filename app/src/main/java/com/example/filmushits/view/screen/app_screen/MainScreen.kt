package com.example.filmushits.view.screen.app_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmushits.R
import com.example.filmushits.view.theme.BackGroundColor
import com.example.filmushits.view.theme.GenreBackground
import com.example.filmushits.view.theme.GenreItemText
import com.example.filmushits.view.theme.TextColor
import com.example.filmushits.view.theme.TextTitle1
import kotlinx.coroutines.delay

@Composable
@Preview
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
            .verticalScroll(rememberScrollState())
            .padding(0.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()){
            Carousel()
        }
        Catalog()
    }
}

@Composable
fun Carousel() {
    val posterList = listOf(
        R.drawable.test_poster,
        R.drawable.test_poster,
        R.drawable.test_poster
    )

    Carousel(images = posterList)
}

@Composable
fun ImageItem(imageRes: Int){
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
    )
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(images:List<Int>){
    val pageCount = images.size

    val state = rememberPagerState { pageCount }

    HorizontalPager(
        state = state,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        ImageItem(imageRes = images[page])
    }
    Row(
        modifier = Modifier
            .offset(y = -(34).dp)
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


@Composable
fun Catalog() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Bottom),
        horizontalAlignment = Alignment.Start,
    ) {
        TextTitle1(text = stringResource(id = R.string.catalog))
        Column(Modifier.clickable { }) {
            filmBanner()
        }

        filmBanner()
        filmBanner()
        filmBanner()
        filmBanner()
        filmBanner()
        filmBanner()

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun filmBanner() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .width(95.dp)
                    .height(130.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.test_banner),
                    contentDescription = stringResource(id = R.string.image_description),
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "Волк с Уолл-стрит",

                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                fontWeight = FontWeight(700),
                                color = TextColor
                            )
                        )
                    }
                    Text(
                        text = "2013 · США", style = TextStyle(
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
                    val GenreList = arrayOf("драма","комедия","криминал", "ужастик")
                    GenreList.forEach {
                        GenreItem(it)
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