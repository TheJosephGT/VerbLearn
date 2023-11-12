package com.example.verblearn.ui.theme.verb

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.verblearn.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TranslateScreen()
{
    val colorCard = Color(0x57D9DDEA)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        HeaderScreen()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        {
            Card(
                Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0x808B8B8B),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .width(401.dp)
                    .height(262.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp)),
                        colors = CardDefaults.cardColors(containerColor = colorCard)

            )
            {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                )
                {
                    Row {
                        Text(
                            text = "Bass form",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )

                        Spacer(modifier = Modifier.width(38.dp))

                        Text(
                            text = "Past participle",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )

                        Spacer(modifier = Modifier.width(38.dp))

                        Text(
                            text = "Simple pass",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(9.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    {
                        Button(onClick = { /*
                    TODO*/ },
                            Modifier
                                .width(182.dp)
                                .height(50.dp)
                                .background(
                                    color = Color(0xFF191D2B),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                        )
                        {
                            Text(
                                text = "Translate",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}