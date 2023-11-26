package com.example.verblearn.ui.theme.verb

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.verblearn.data.local.entities.Favorite
import com.example.verblearn.ui.theme.navigation.Destination
import com.example.verblearn.ui.theme.viewModel.VerbViewModel


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun FavoriteScreen(verbs: List<Favorite>, navController: NavController, viewModel: VerbViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
                    Text(
                        text = "Favorites",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            }

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(verbs){verb ->
                    Card(
                        modifier =
                        Modifier
                            .width(366.49536.dp)
                            .height(90.dp)
                            .clickable {
                            val verbActual = uiState.verbs.singleOrNull{it.baseForm == verb.baseForm}
                                if (verbActual != null) {
                                    navController.navigate("${Destination.Translate.route}/${verbActual.id}")
                                }
                            }
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
                                Column {
                                    Text(
                                        text = "Base form",
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF000000),
                                        )
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = verb.baseForm, modifier = Modifier.align(Alignment.CenterHorizontally),
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
                                        text = "Past participle",
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF000000),
                                        )
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = verb.pastParticiple, modifier = Modifier.align(Alignment.CenterHorizontally),
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
                                        text = "Simple past",
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF000000),
                                        )
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = verb.simplePast, modifier = Modifier.align(Alignment.CenterHorizontally),
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

                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}