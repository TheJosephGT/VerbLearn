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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
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
import com.example.verblearn.ui.theme.viewModel.VerbViewModel


@SuppressLint(
    "SuspiciousIndentation", "CoroutineCreationDuringComposition",
    "UnrememberedMutableState"
)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun TranslateScreen(idVerb: Int, viewModel: VerbViewModel = hiltViewModel()) {
    val colorCard = Color(0xFFFFFFFF)
    val colorCardDefinition = Color(0x57D9DDEA)
    var translateOn by mutableStateOf(false)
    val favorites by viewModel.favorites.collectAsState()

    DisposableEffect(Unit) {
        viewModel.getVerbById(idVerb)
        onDispose {}
    }

    var favoriteOn by mutableStateOf(false)
    val currentFavorite = favorites.find { it.baseForm == viewModel.verb.baseForm }
    if (currentFavorite != null) {
        favoriteOn = true
    }


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
                                text = "Base form", fontWeight = FontWeight.Bold,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = viewModel.verb.baseForm,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                            if (translateOn) {
                                Text(
                                    text = "(${viewModel.verb.spanishBaseForm})",
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
                                text = viewModel.verb.pastParticiple,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                            if (translateOn) {
                                Text(
                                    text = "(${viewModel.verb.spanishPastParticiple})",
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
                                text = "Simple past", fontWeight = FontWeight.Bold,

                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = viewModel.verb.simplePast,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                )
                            )
                            if (translateOn) {
                                Text(
                                    text = "(${viewModel.verb.spanishSimplePast})",
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
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(9.dp)
                        .align(Alignment.CenterHorizontally)

                )
                {
                    Switch(
                        checked = translateOn,
                        onCheckedChange = {
                            translateOn = it
                        },
                        thumbContent = if (translateOn) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(SwitchDefaults.IconSize),
                                )
                            }
                        } else {
                            null
                        }
                    )
                }
                Row {
                    Spacer(modifier = Modifier.width(330.dp))

                    IconButton(
                        onClick = { favoriteOn = !favoriteOn },
                    ) {
                        if (favoriteOn) {
                            Icon(
                                imageVector = Icons.Rounded.Star,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(48.dp)
                            )
                            if (currentFavorite == null) {
                                viewModel.saveVerbAsFavorite(viewModel.verb)
                            }
                        } else {
                            Icon(
                                imageVector = Icons.Filled.StarBorder,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(48.dp)
                            )
                            if (currentFavorite != null) {
                                viewModel.deleteVerbAsAVerb(currentFavorite)
                            }
                        }
                    }
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                Modifier
                    .padding(0.5.dp)
                    .width(401.dp)
                    .height(230.dp),
                colors = CardDefaults.cardColors(containerColor = colorCardDefinition)

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
                        text = viewModel.verb.definition,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    )
                    if (translateOn) {
                        Text(
                            text = "(${viewModel.verb.definitionInSpanish})",
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
        }
    }
}