package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableStateOf(1) }

    val imageRes: Int
    val title: String
    val artistAndYear: String

    when (currentArtwork) {
        1 -> {
            imageRes = R.drawable.artwork1
            title = "Earth from space"
            artistAndYear = "Атмосферные подборки (2020)"
        }
        2 -> {
            imageRes = R.drawable.artwork2
            title = "Milky Way Views"
            artistAndYear = "Milky Way  (2025)"
        }
        else -> {
            imageRes = R.drawable.artwork3
            title = "The Milky Way"
            artistAndYear = "by Jason Huert (2019)"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .border(2.dp, Color.Black)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .border(2.dp, Color.Gray)
                .padding(8.dp)
        ) {
            Text(text = title, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(text = artistAndYear, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentArtwork > 1) currentArtwork-- },
                modifier = Modifier.weight(1f),
                enabled = currentArtwork > 1
            ) {
                Text(stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { if (currentArtwork < 3) currentArtwork++ },
                modifier = Modifier.weight(1f),
                enabled = currentArtwork < 3
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}