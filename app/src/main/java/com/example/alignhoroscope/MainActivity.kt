package com.example.alignhoroscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { MainPage { zodiacSign -> navController.navigate("horoscope/$zodiacSign") } }
                composable(
                    route = "horoscope/{zodiacSign}",
                    arguments = listOf(navArgument("zodiacSign") { })
                ) { backStackEntry ->
                    val zodiacSign = backStackEntry.arguments?.getString("zodiacSign") ?: ""
                    HoroscopeScreen(zodiacSign)
                }
            }
        }
    }
}

val zodiacSigns = listOf(
    "aries",
    "taurus",
    "gemini",
    "cancer",
    "leo",
    "virgo",
    "libra",
    "scorpio",
    "sagittarius",
    "capricorn",
    "aquarius",
    "pisces"
)

@Composable
fun ZodiacList(onHoroscopeClicked: (String) -> Unit) {
    zodiacSigns.forEach { zodiacSign -> ZodiacCard(zodiacSign, onHoroscopeClicked) }
}

@Composable
fun ZodiacSVG(zodiacSign: String) {
    val imageResId = when (zodiacSign.lowercase(Locale.ROOT)) {
        "aries" -> R.drawable.aries
        "taurus" -> R.drawable.taurus
        "gemini" -> R.drawable.gemini
        "cancer" -> R.drawable.cancer
        "leo" -> R.drawable.leo
        "virgo" -> R.drawable.virgo
        "libra" -> R.drawable.libra
        "scorpio" -> R.drawable.scorpio
        "sagittarius" -> R.drawable.sagittarius
        "capricorn" -> R.drawable.capricorn
        "aquarius" -> R.drawable.aquarius
        "pisces" -> R.drawable.pisces
        else -> R.drawable.gemini // fallback image
    }

    val image: Painter = painterResource(id = imageResId)
    Image(painter = image, contentDescription = zodiacSign, modifier = Modifier.size(100.dp))
}

@Composable
fun ZodiacCard(
    zodiacSign: String,
    onHoroscopeClicked: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onHoroscopeClicked(zodiacSign) }
    ) {
        Text(
            text = zodiacSign.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
            },
            modifier = Modifier.padding(end = 8.dp)
        )
        ZodiacSVG(zodiacSign)
    }
}

@Composable
fun HoroscopeScreen(
    zodiacSign: String,
) {
//     Get the ViewModel
    val viewModel: HoroscopeViewModel = hiltViewModel()

//     Observe the horoscope state
    val horoscope by viewModel.horoscope.observeAsState("")

//     Fetch the horoscope when the screen is displayed
    LaunchedEffect(zodiacSign) {
        viewModel.fetchHoroscope(zodiacSign)
    }

//    Text(text = "Horoscope for $zodiacSign: $horoscope")
    Text("whats up $zodiacSign")
}

