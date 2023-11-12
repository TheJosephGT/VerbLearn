package com.example.verblearn.ui.theme.verb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.verblearn.R

@Composable
fun SplashScreen() {
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

    Box(
        modifier = Modifier
            .width(430.dp)
            .height(932.dp)
            .background(color = Color(0xFF191D2B)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                fontSize = 48.sp,
                fontWeight = FontWeight(400),
            )
            Image(
                painter = painterResource(id = R.drawable._223),
                contentDescription = "Descripción de la imagen",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(300.dp)

            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
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
            Column(modifier = Modifier
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
        homeBody()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeBody()
{

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
    {
        Row{
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
            {
                CustomOutlinedTextField(
                    value ="",
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
            Modifier
                .width(366.49536.dp)
                .height(314.18869.dp)
                .align(Alignment.CenterHorizontally)
                .background(color = Color(0x57D9DDEA), shape = RoundedCornerShape(size = 20.dp))


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