package com.example.verblearn.ui.theme.verb

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.verblearn.ui.theme.navigation.Destination
import com.example.verblearn.ui.theme.viewModel.VerbViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: VerbViewModel = hiltViewModel()) {
    var searchedVerb by mutableStateOf("")
    val snackbarHostState = remember { SnackbarHostState() }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val colorCard = Color(0x57D9DDEA)
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ){
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
                        OutlinedTextField(
                            value = searchedVerb,
                            onValueChange = {searchedVerb = it},
                            modifier = Modifier.width(350.dp),
                            label = { Text(text = "Type the verb") },
                            singleLine = true,
                            trailingIcon = {
                                Icon(
                                    Icons.Default.ArrowForward,
                                    contentDescription = "Icono hacia la derecha",
                                    Modifier.clickable(onClick = {navController.navigate("${Destination.Translate.route}/${uiState.verbs.singleOrNull{ 
                                            verb -> verb.baseForm.lowercase() == searchedVerb.lowercase() ||
                                            verb.pastParticiple.lowercase() == searchedVerb.lowercase() ||
                                            verb.simplePast.lowercase() == searchedVerb.lowercase()}?.id}")})
                                )
                            }
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
                                text = "Base form",
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
                                text = "Simple past",
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
}

