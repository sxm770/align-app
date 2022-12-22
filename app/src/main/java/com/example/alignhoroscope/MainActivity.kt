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
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alignhoroscope.ui.theme.AlignhoroscopeTheme
import okhttp3.OkHttpClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlignhoroscopeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        HomePageHeader()
                        ZodiacList()
                    }
                }
            }
        }
    }
}

val zodiacSigns = listOf("aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio","sagittarius", "capricorn", "aquarius", "pisces")
val days = listOf("today", "yesterday", "tomorrow")

val client = OkHttpClient()

//val request = Request.Builder()
//    .url("https://sameer-kumar-aztro-v1.p.rapidapi.com/?sign={${zodiacSigns[2]}}&day={${days[0]}}")
//    .addHeader("X-RapidAPI-Key", "fd7fe46ae1msh1ea3cf087dfadc9p1969ebjsn0558213f4849")
//    .addHeader("X-RapidAPI-Host", "sameer-kumar-aztro-v1.p.rapidapi.com")
//    .build()


//val response = client.newCall(request).execute()
//val responseString = request.body.toString()

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
fun ZodiacList() {
    zodiacSigns.forEach { zodiacSign -> ZodiacCard(zodiacSign) }
}

@Composable
fun ZodiacSVG() {
    val image: Painter = painterResource(id = R.drawable.aquarius)
    Image(painter = image,contentDescription = "", modifier = Modifier.size(100.dp))
}

@Composable
fun ZodiacCard(
    zodiacSign: String,
) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickable { }
            ) {
            Text(text = zodiacSign.capitalize())
            ZodiacSVG()
        }
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlignhoroscopeTheme {
        HomePageHeader()
    }
}
