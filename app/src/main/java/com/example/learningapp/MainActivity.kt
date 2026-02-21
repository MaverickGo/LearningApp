package com.example.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningapp.ui.theme.LearningAppTheme
import com.example.learningapp.ui.theme.PlayfairDisplay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val input = remember{mutableStateOf("")}
            val toDoList = remember{ mutableStateListOf("") }

            LearningAppTheme {
                Scaffold(modifier = Modifier.padding()) { innerPadding ->
                    BackgroundColor(0xFFF0FFFF)
                    Surface(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        color = (Color(0x00FFFFFF))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Greeting()
                            Input(input, toDoList)
                            ToDoList(toDoList)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    val input = remember{mutableStateOf("")}
    val toDoList = remember{ mutableStateListOf("") }

    LearningAppTheme {
        Scaffold(modifier = Modifier.padding()) { innerPadding ->
            BackgroundColor(0xFFF0FFFF)
            Surface(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                color = (Color(0x00FFFFFF))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Greeting()
                    Input(input, toDoList)
                    ToDoList(toDoList)
                }
            }
        }
    }
}

@Composable
fun BackgroundColor(colorHex: Long) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(colorHex))
    )
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to my ToDoList!",
            fontSize = 26.sp,
            color = Color(0xFF4169E1),
            fontFamily = PlayfairDisplay,
            fontWeight = Bold
        )
    }
}

@Composable
fun Input(input: MutableState<String>, toDoList: SnapshotStateList<String>){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ){
        TextField(
            value = input.value,
            onValueChange = { newText -> input.value = newText },
            placeholder = { Text(text = "Аdd a new task", fontFamily = PlayfairDisplay, fontWeight = Bold) },
            singleLine = true,
            modifier = Modifier
                .size(width = 250.dp, height = 50.dp)
        )
        Button(
            onClick = { toDoList.add(input.value); input.value = ""},
            shape = RectangleShape,
            modifier = Modifier
                .size(width = 70.dp, height = 50.dp)
        ) {
            Text("+", fontSize = 20.sp)
        }
    }
}

@Composable
fun ToDoList(toDoList: SnapshotStateList<String>){
    LazyColumn(

    ) {
        items(
            toDoList
        ){
            task -> Text(task)
        }
    }
}


