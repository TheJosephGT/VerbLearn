package com.example.verblearn.ui.theme.verb

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeBody() {
    val colorCard = Color(0x57D9DDEA)

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
                CustomOutlinedTextField(
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
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.width(350.dp),
        label = { Text(text = label) },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (isError) Color.Gray else Color.Red,
            unfocusedBorderColor = if (isError) Color.Gray else Color.Red
        ),
        trailingIcon = {
            Icon(
                Icons.Default.ArrowForward,
                contentDescription = "Icono hacia la derecha"
            )
        }
    )
}