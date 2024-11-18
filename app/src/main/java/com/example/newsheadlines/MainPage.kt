package com.example.newsheadlines

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.example.Articles
import com.example.newsheadlines.ui.theme.NewsHeadlinesTheme

// Import HtmlText function
import com.example.newsheadlines.HtmlText

class MainPage : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsHeadlinesTheme {
                // Set the background color to purple for the whole screen
                Surface(
                    color = Color(0xFFF6F2F2), // Purple background
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column {
                        // Box for the Latest News heading with a yellow background and curved edges
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                                .background(
                                    color = Color.Yellow, // Yellow background
                                    shape = RoundedCornerShape(10.dp) // Curved edges
                                )
                                .padding(16.dp) // Inner padding for the text
                        ) {
                            Text(
                                text = "Latest NEWS",
                                fontSize = 32.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.SansSerif, // Use built-in SansSerif style
                                fontWeight = FontWeight.Normal,
                                color = Color.Black // Black text color for contrast
                            )
                        }

                        // Display movie list
                        MovieList(applicationContext, movieList = mainViewModel.movieListResponse)
                        mainViewModel.getMovieList()
                    }
                }
            }
        }
    }
}

@Composable
fun MovieList(context: Context, movieList: List<Articles>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            MovieItem(context, movie = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }
}

@Composable
fun MovieItem(context: Context, movie: Articles, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {
    val backgroundColor = if (index == selectedIndex) MaterialTheme.colors.primary else Color(
        0xFF5D5C62
    )

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .clickable { onClick(index) }
            .height(180.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Surface(color = backgroundColor) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                // Image section - stretched vertically
                Image(
                    painter = rememberImagePainter(
                        data = movie.urlToImage,
                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.placeholder)
                        }
                    ),
                    contentDescription = movie.description,
                    modifier = Modifier
                        .height(300.dp ) // Stretches the image to match the full height of its parent
                        .weight(0.3f) // Ensures proportional layout alongside the text content
                )

                // Text content inside a white box
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.7f) // Adjust weight as needed
                        .background(Color.White) // White background inside the movie item
                        .padding(20.dp)
                        .clickable {
                            Log.i("MovieItem", "Clicked: ${movie.description}")
                            context.startActivity(
                                Intent(context, DisplayNews::class.java)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    .putExtra("desk", movie.description.toString())
                                    .putExtra("urlToImage", movie.urlToImage)
                                    .putExtra("title", movie.title)

                            )
                        }
                ) {
                    Text(
                        text = movie.title.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    HtmlText(html = movie.description.toString(), modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}