package com.example.alignhoroscope

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alignhoroscope.ui.theme.AlignhoroscopeTheme
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") { MainPage { zodiacSign -> navController.navigate("horoscope/$zodiacSign") } }
                composable(
                    route ="horoscope/{zodiacSign}",
                    arguments = listOf(navArgument("zodiacSign") { }),
                    content = {
                        Text(text = "${it.arguments?.getString("zodiacSign")}")
                    }
                )
            }
        }
    }

    @Composable
    private fun MainPage( onHoroscopeClicked : (String) -> Unit ) {
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
}

val zodiacSigns = listOf("aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio","sagittarius", "capricorn", "aquarius", "pisces")
val days = listOf("today", "yesterday", "tomorrow")

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
fun ZodiacSVG(zodiacSign : String) {
    val image: Painter = painterResource(id = R.drawable.aquarius)
    Image(painter = image, contentDescription = "$zodiacSign", modifier = Modifier.size(100.dp))
}

@Composable
fun ZodiacCard(
    zodiacSign: String,
    onHoroscopeClicked: (String) -> Unit,
) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {onHoroscopeClicked(zodiacSign)}
            ) {
            Text(text = zodiacSign.capitalize())
            ZodiacSVG(zodiacSign)
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlignhoroscopeTheme {
        HomePageHeader()
    }
}
