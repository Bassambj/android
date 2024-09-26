package com.bassam.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bassam.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    MessageCard(Message())
                }
                }
            }
        }
    }

data class Message(val author: String = "Android.", val body: String = " Welcome!")

@Composable
fun MessageCard(msg: Message){
    // Add padding around our message
    Row (modifier = Modifier.padding(all= 8.dp)){
        Image(
            painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                // Use Material Theme for color stile border
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text= msg.author,
                // Color and style with MaterialTheme
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = msg.body,
                // Style with MaterialTheme
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme{
       Surface {
           MessageCard(Message())
       }
    }
}
