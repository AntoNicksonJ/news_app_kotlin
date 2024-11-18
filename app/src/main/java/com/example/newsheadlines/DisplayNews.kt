package com.example.newsheadlines

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.rememberImagePainter
import com.example.newsheadlines.ui.theme.NewsHeadlinesTheme

class DisplayNews : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsHeadlinesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF2F2A1A) // Outer background color (light purple)
                ) {
                    val desk = intent.getStringExtra("desk") ?: "No description available"
                    val title = intent.getStringExtra("title") ?: "No title available"
                    val uriImage = intent.getStringExtra("urlToImage")
                    Log.i("test123abc", "MovieItem: $desk")

                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Image occupies the upper portion of the purple container
                        Image(
                            painter = rememberImagePainter(uriImage),
                            contentDescription = "News image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp) // Adjust height for image
                        )

                        // Title and description container with rounded corners
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp), // Outer padding
                            elevation = 8.dp, // Shadow for the card
                            backgroundColor = Color.White,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp) // Rounded corners
                        )
                        {
                            Column(
                                modifier = Modifier.padding(16.dp), // Inner padding for the card content
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Top
                            ) {
                                Text(
                                    text = title,
                                    fontSize = 24.sp,
                                    color = Color.Black
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                HtmlText(html = desk) // News description
                            }
                        }
                    }
                }
            }
        }
    }
}

// Custom composable for displaying HTML text
@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context -> TextView(context) },
        update = { it.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsHeadlinesTheme {
        // Preview layout
    }
}