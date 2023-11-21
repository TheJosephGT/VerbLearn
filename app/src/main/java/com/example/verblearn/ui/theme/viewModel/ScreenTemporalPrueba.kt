package com.example.verblearn.ui.theme.viewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.verblearn.data.remote.dto.VerbsDTO

@Composable
fun Consult(verbs: List<VerbsDTO>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Lista de verbos", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(verbs) { verb ->
                if(verb.baseForm == "Run" || verb.simplePast == "Run" || verb.pastParticiple == "Run")
                    VerbItem(verb)
            }
        }
    }
}

@Composable
fun VerbItem(verb: VerbsDTO, viewModel: VerbViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "baseForm: " + verb.baseForm, style = MaterialTheme.typography.titleMedium)
            Text(text = "pastParticiple: " + verb.pastParticiple, style = MaterialTheme.typography.titleMedium)
            Text(text = "simplePast: " + verb.simplePast, style = MaterialTheme.typography.titleMedium)
        }
    }
}