package com.example.verblearn.ui.theme.verb

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.widget.NestedScrollView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.verblearn.ui.theme.viewModel.VerbViewModel
import com.example.verblearn.util.CustomOutlinedTextField

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportScreen(viewModel: VerbViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    )
    {
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
                    .verticalScroll(scrollState)
                    .height(550.dp)

            )
            {

                Text(
                    text = "Insert the missing verb",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        CustomOutlinedTextField(
                            value = viewModel.baseForm,
                            onValueChange = { viewModel.baseForm = it },
                            label = "Bass form"
                        )
                        if (viewModel.verificarBassForm == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )

                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    ) {
                        CustomOutlinedTextField(
                            value = viewModel.pastParticiple,
                            label = "Past participle",
                            onValueChange = { viewModel.pastParticiple = it },
                        )
                        if (viewModel.verificarPastParticiple == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        CustomOutlinedTextField(
                            value = viewModel.simplePast,
                            onValueChange = { viewModel.simplePast = it },
                            label = "Simple past"
                        )
                        if (viewModel.verificarSimplePast == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    ) {
                        CustomOutlinedTextField(
                            value = viewModel.spanishBaseForm,
                            label = "Spanish base form",
                            onValueChange = { viewModel.spanishBaseForm = it },
                        )
                        if (viewModel.verificarSpanishBaseForm == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        CustomOutlinedTextField(
                            value = viewModel.spanishSimplePast,
                            onValueChange = { viewModel.spanishSimplePast = it },
                            label = "Spanish simple past"
                        )
                        if (viewModel.verificarSpanishSimplePast == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }

                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        CustomOutlinedTextField(
                            value = viewModel.spanishPastParticiple,
                            onValueChange = { viewModel.spanishPastParticiple = it },
                            label = "Spanish Past Participle"
                        )
                        if (viewModel.verificarPastParticiple == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }

                }

                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        CustomOutlinedTextField(
                            value = viewModel.definition,
                            onValueChange = { viewModel.definition = it },
                            label = "Definition in english"
                        )
                        if (viewModel.verificarDefinition == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    {
                        CustomOutlinedTextField(
                            value = viewModel.definitionInSpanish,
                            onValueChange = { viewModel.definitionInSpanish = it },
                            label = "Definition in spanish"
                        )
                        if (viewModel.verificarDefinitionInSpanish == false) {
                            Text(
                                text = "This field is required.",
                                color = Color.Red,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Button(
                        onClick = {
                            if (viewModel.validar()) {
                                viewModel.send()
                            }
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
                            text = "Send",
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