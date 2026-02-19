package com.example.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Scaffold(modifier = Modifier.padding()) {innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(all = 20.dp)
                            .fillMaxSize()
                    ) {
                        for (item in listItems){
                            ListItem(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(content: Item) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(50.dp, 50.dp)
                .background(Color(content.boxColor)),
        )
        Text(
            text = content.text,
            modifier = Modifier
                .offset(x = 15.dp),
            fontSize = 26.sp,
            letterSpacing = 1.sp,
            color = Color(content.textColor)

        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    LearningAppTheme {
        Scaffold(modifier = Modifier.padding()) {innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(all = 20.dp)
                    .fillMaxSize()
            ) {
                for (item in listItems){
                    ListItem(item)
                }
            }
        }
    }
}

data class Item(val text: String, val textColor:Long = 0xFF000000, val boxColor:Long)
val listItems = listOf(
    Item(text = "Oranges", boxColor = 0xffFFA500),
    Item(text = "Tomatoes", boxColor = 0xffFF0000),
    Item(text = "Apples", boxColor = 0xff7CFC00),
)

