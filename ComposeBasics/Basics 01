package com.bassam.composebasics

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.bassam.composebasics.ui.theme.ComposeBasicsTheme
import java.util.concurrent.CountedCompleter


// Boas praticas cursos compose basics workshop - codigo mais reuilizavel
// colocou o MyApp dentro da main e transferiu o texto padrao q estava ali pro texto da função.
// Entre outras modificações.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreenContent()
               }
            }
        }

@Composable
fun Counter(){
    var counter by remember {
        mutableStateOf(0)}
    Button(onClick = { counter++ }) {
        Text(text = "I´ve been clicked $counter times")
    }
}

@Composable
fun MyApp(content: @Composable ()->Unit){ // ()->Unit Não aceita argumentos e não retorna nada
    ComposeBasicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            MyScreenContent()
        }
    }
}

//Coloquei tudo na MyScreencontent que é chamada no preview e no app
@Composable //Função criada para organização do layout, da screen, permitindo reuso.
fun MyScreenContent(names: List<String> = listOf("Android","There")){
    // foir criada uma lista passada por parâmetro,diminuindo o tamanho do código
    // que lê cada nome da lista e mostra  na screen
    Column {
        for (name: String in names){
            Greeting(name = name)
            Divider()
        }
        Counter()
        Counter()
    }

}


@Composable
fun Greeting(name: String) {
    Surface(color = androidx.compose.ui.graphics.Color.Yellow) {
        Text(text = "Hello $name!")
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
