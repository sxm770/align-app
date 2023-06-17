package com.example.alignhoroscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.alignhoroscope.ui.theme.AlignhoroscopeTheme
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

@Composable
private fun MainPage(onHoroscopeClicked: (String) -> Unit) {
    AlignhoroscopeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                HomePageHeader()
                ZodiacList(onHoroscopeClicked)
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
fun HomePageHeader() {
    Column {
        Text(
            stringResource(R.string.choose_zodiac).uppercase(),
            fontSize = 20.sp,
            maxLines = 1,
            textAlign = Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 20.dp)

        )
    }
}

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
    Text(text = "what up $zodiacSign")
}
