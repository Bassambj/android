package laboratory

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ValueElement
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Column {
            //Funções de ordem superior/higher order functions
            Start()
        }
    }

}

@Composable
@Preview
fun Start() {
    //Argumentos padrão/default arguments
    var text by remember { mutableStateOf("Hello...") }
    //Escopos e Receptores/Scopes and Receivers / in this case, Scope only for Column scope;

    DesktopMaterialTheme {
            Button(onClick = {
                //Objetos singleton/Singleton objects
                Dropper.cleanDropper()
                Dropper.getLiquid(2.5)
                Dropper.dropLiquid(.4)
                var x = Dropper.dropStatus()
                text = "WELCOME TO MY KOTLIN LABORATORY!" +"\n"+
                        "\n INSTRUMENTS:" +
                        "\nThe balance have ${Balance.result} kgs" +
                        "\nThe burner is on? ${Burner.burning}"+
                        "\nThe combustion spoon is on? ${CombustionSpoon.burningSpoon}"+
                        "\nThe dropper have $x units" +
                        "\nThe microscope is set to ${Microscope.zoom} zoom. "
                        

            }) {
                Text(text)
            }

    }
}

//project in development
// coming soon ;)
