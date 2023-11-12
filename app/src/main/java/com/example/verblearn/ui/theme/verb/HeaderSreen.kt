package com.example.verblearn.ui.theme.verb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.verblearn.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderScreen() {
    val color = Color(0xFF65D0F2)
    val colorBlanco = Color(0xFFFFFFFF)

    val text = AnnotatedString.Builder("VerbLearn")
        .apply {
            addStyle(
                style = SpanStyle(color),
                start = 0,
                end = 4
            )
            addStyle(
                style = SpanStyle(colorBlanco),
                start = 4,
                end = 9
            )
        }
        .toAnnotatedString()


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(430.dp)
                .height(183.dp)
                .background(color = Color(0xFF191D2B)),
        ) {
            Image(
                painter = painterResource(id = R.drawable._223),
                contentDescription = "Descripción de la imagen",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(60.dp)

            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
                Box(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .background(color = Color(0xFF191D2B)),
                    contentAlignment = Alignment.Center

                )
                {
                    Text(
                        text = text,
                        fontSize = 48.sp,
                        fontWeight = FontWeight(400)
                    )
                }
            }
        }

        HomeBody()
    }

}