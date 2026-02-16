package com.example.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningapp.ui.theme.LearningAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningAppTheme {
                Screen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFun(){
    LearningAppTheme {
        Screen()
    }
}

@Composable
fun Screen() {
    var clickCount = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .background(color = Color(0xFFFFFFE0))
            .offset(y = 40.dp)
            .fillMaxSize()
    ) {
        Greeting()
        Label()
        ClicksCounter(clickCount.value)
        Button(clickCount)
    }
}

@Composable
fun Greeting() {
    Text(
        text = "Welcome to my clicker!",
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Label() {
    Text(
        text = "Here you can only click the button at the bottom of the screen",
        fontSize = 16.sp,
        modifier = Modifier
            .offset(y = 10.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun ClicksCounter(clickCount: Int) {
    Text(
        text = "You clicked $clickCount times",
        fontSize = 18.sp,
        modifier = Modifier
            .offset(y = 200.dp)
            .fillMaxWidth()
            .background(Color(0xFFF4A460))
            .padding(vertical = 12.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Button(clickCount: MutableState<Int>) {
    Box(
        modifier = Modifier
            .offset(y = 500.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Click me",
            fontSize = 18.sp,
            modifier = Modifier
                .clickable(
                    onClick = { clickCount.value += 1 },
                    role = Role.Button
                )
                .width(250.dp)
                .background(Color(0xFF8B4513), shape = RoundedCornerShape(30.dp))
                .padding(vertical = 15.dp)                ,
            textAlign = TextAlign.Center
        )
    }
}