package com.example.alignhoroscope

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alignhoroscope.ui.theme.AlignhoroscopeTheme

@Composable
fun MainPage(onHoroscopeClicked: (String) -> Unit) {
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

@Composable
fun HomePageHeader() {
    Column {
        Text(
            stringResource(R.string.choose_zodiac).uppercase(),
            fontSize = 20.sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 20.dp)

        )
    }
}