package com.example.verblearn.ui.theme.verb

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresExtension
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.verblearn.ui.theme.viewModel.VerbViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@SuppressLint("SuspiciousIndentation")
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun TranslateScreen(searchedVerb: String, viewModel: VerbViewModel = hiltViewModel()) {
    val colorCard = Color(0xFFFFFFFF)
    val ColorCardDefinition = Color(0x57D9DDEA)

    val CurrentVerb = viewModel.searchVerb(searchedVerb = searchedVerb)
 //   if(CurrentVerb != null) {
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
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 20.dp)
                        ),
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
                            Column {
                                Text(
                                    text = "Bass form", fontWeight = FontWeight.Bold,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                if (CurrentVerb != null) {
                                    Text(
                                        text = CurrentVerb.baseForm,
                                        modifier = Modifier.align(Alignment.CenterHorizontally),
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF000000),
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(38.dp))

                            Column {
                                Text(
                                    text = "Past participle", fontWeight = FontWeight.Bold,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "",
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.width(38.dp))

                            Column {
                                Text(
                                    text = "Simple pass", fontWeight = FontWeight.Bold,

                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text ="",
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                    )
                                )
                            }
                        }

                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(9.dp)
                            .align(Alignment.CenterHorizontally)

                    )
                    {
                        val color = Color(0xFF191D2B)
                        Button(
                            onClick = { /*
                    TODO*/
                            },
                            Modifier
                                .width(182.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(size = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF191D2B),
                                contentColor = Color(0xFF191D2B)
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
                    Row {
                        Spacer(modifier = Modifier.width(330.dp))

                        IconButton(
                            onClick = {
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.StarBorder,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    Modifier
                        .padding(0.5.dp)
                        .width(401.dp)
                        .height(230.dp),
                    colors = CardDefaults.cardColors(containerColor = ColorCardDefinition)

                )
                {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        Text(
                            text = "Definition: ", fontWeight = FontWeight.Bold,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        Text(
                            text = "Example: ", fontWeight = FontWeight.Bold,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "(AQUI VA EL EXAMPLE): ",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                }
            }
        }
 //   }
}