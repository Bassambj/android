package com.bassam.composebasics

import android.graphics.Color.*
import android.graphics.SurfaceTexture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.generateDecayAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bassam.composebasics.ui.theme.*
import java.util.concurrent.CountedCompleter

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
    // List set im parameter for function NameList.
    var counterState: Int by remember {
        mutableStateOf(0)
    }// Modifier.fillMaxHeight
    Column() {
        Row(
            Modifier
                .padding(20.dp)
                .border(1.dp, Color.Green, RectangleShape)//Video: "Thinnkin in Compose"
        ) {
            Row(Modifier
                .padding(horizontal = 4.dp,vertical = 4.dp)) {
                Text(text = "Jetpack Compose Basics | Workshop",
                    color = Green700,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Black)
            }
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
    // lazyColumn like a recycle view in android view
    // The list is able to scroll
    //few code, no need implement view, recycle view or adapter the view holders...
    // LazyColumn is amazing, only 4 lines of code...
    LazyColumn(modifier = modifier) {
        items(items = names){
            Greeting(name = it)
            Divider()
        }
    }
}



@Composable
// update function
fun Counter(count: Int, updateCount: (Int) -> Unit){
    Button(onClick = { updateCount(count+1) }) {
        Text(text = "I´ve been clicked $count times")
    }
}

@Composable
fun Greeting(name: String){
    //Implement animations or changes if text is clicked...
    var isSelected : Boolean by remember {
        mutableStateOf(false)
    }
    // Changes if clicked:
    // In the video the if is: Color.Red else Color.Transparent, here android studio say is redundant...
    // transition use by abimateColorAsState
    val targetColor : Color by animateColorAsState( //by -> delegate is easier to use
        // I use my color defined in Color.kt (res):
        targetValue = if (isSelected) SkyBlue300 else Transparent,
        // or  // You can use material Theme directly:
        // targetValue = if (isSelected) MaterialTheme.colors.primary else Transparent,

        //time for animation transition:
        animationSpec = tween(durationMillis = 1500)
    )
    Surface(color = targetColor) {
        Text(text = "Hello $name!",
        modifier = Modifier
            .clickable { isSelected = !isSelected }
            .padding(16.dp)

        )
    }
}

// @Preview(fontScale = 1.5f) you can have more previews..
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        MyScreenContent()
    }
}
