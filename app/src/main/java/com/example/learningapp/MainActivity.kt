package com.example.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Content("Mirasvet")
            }
        }
    }
}

@Composable
fun Content(name: String = "Default") {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(top = 50.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = "Hello World!",
            modifier = Modifier
                .background(Color.Yellow)
                .padding(all = 20.dp),
            fontSize = 20.sp,
            color = Color(red = 255, green = 0, blue = 0)
        )
        Text(
            text = "Your name is $name",
            modifier = Modifier
                .padding(top = 100.dp)
                .background(
                    shape = CircleShape,
                    color = Color.Green
                )
                .padding(top = 5.dp)
                .width(300.dp)
                .height(50.dp),
            fontSize = 20.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearningAppTheme {
        Content("Mirasvet")
    }
}
