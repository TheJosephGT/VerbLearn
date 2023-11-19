package com.example.verblearn.ui.theme.verb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.verblearn.util.SearchTextField

@Composable
fun HomeBody() {

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
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
                {
                    SearchTextField(
                        value = "",
                        onValueChange = { },
                        label = "Txt",
                        isError = true,
                    )
                }

            }

            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
                {
                    Text(
                        text = "Recent verbs",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight(400),
                        )
                    )
                }
            }

            Card(
                modifier =
                Modifier
                    .width(366.49536.dp)
                    .height(314.18869.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(containerColor = colorCard)
            ) {
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
                }
            }
        }
    }
}