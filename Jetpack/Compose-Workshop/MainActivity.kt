package com.bassam.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bassam.composebasics.ui.theme.ComposeBasicsTheme
import com.bassam.composebasics.ui.theme.Green700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreenContent()
               }
            }
        }

// MyScreenContent call in MainActivity and the preview
@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android $it" }) {
    // List set in parameter for function NameList.
    var counterState: Int by remember {
        mutableStateOf(0)
    }// Modifier.fillMaxHeight
    Column() {
        Row(Modifier.padding(8.dp)) {
            Text(text = "Jetpack Compose Basics | Workshop",
                color = Green700,
                fontFamily = FontFamily.SansSerif
            )
        }
        Column(modifier = Modifier.fillMaxHeight()) {
            // Modifier.weight
            NameList(names = names, modifier = Modifier.weight(1f))
            Counter(
                count = counterState,
                updateCount = { newCount: Int ->
                    counterState = newCount
                }
            )
            if (counterState > 5) {
                Text(text = "I love to count!")
            }
        }
    }
}

@Composable
fun NameList(names: List<String>,modifier: Modifier = Modifier){
    // LazyColumn like a recycle view in android view
    // The list is able to scroll. Few code, no need implement view, recycle view or adapter the view holders... LazyColumn is amazing, only 4 lines of code...
    LazyColumn(modifier = modifier) {
        items(items = names){
            Greeting(name = it)
            Divider()
        }
    }
}


@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit){
    Button(onClick = { updateCount(count+1) }) {
        Text(text = "I´ve been clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = androidx.compose.ui.graphics.Color.Yellow) {
        Text(text = "Hello $name!")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        MyScreenContent()
    }
}


