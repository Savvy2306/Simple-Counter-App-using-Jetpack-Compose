package com.sarvesh.counterApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarvesh.counterApp.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SetUi()
                }
            }
        }
    }
}

@Composable
private fun SetUi() {
    val count = remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //in jetpack we use padding to give margin to layout
        Text(
            text = count.intValue.toString(),
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp),
            fontSize = 40.sp
        )

        Button(onClick = {
            count.intValue++
        }) {
            Text(text = stringResource(id = R.string.increment))
        }
        Button(onClick = {
            count.intValue--
        }) {
            Text(text = stringResource(id = R.string.decrement))
        }
        ClickableText(text = AnnotatedString(stringResource(id = R.string.reset)),
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace
            ),
            onClick = {
                count.intValue = 0
            })
    }
}