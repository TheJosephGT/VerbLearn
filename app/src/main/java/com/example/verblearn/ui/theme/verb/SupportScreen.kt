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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.verblearn.util.CustomOutlinedTextField

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SupportScreen() {

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
                        value = "",
                        onValueChange = { },
                        label = "Txt"
                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    CustomOutlinedTextField(
                        value = "",
                        label = "Txt",
                        onValueChange = {},
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            {
                CustomOutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = "Txt"
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            {
                CustomOutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = "Txt"
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
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