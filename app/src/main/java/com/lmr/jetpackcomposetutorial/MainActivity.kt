package com.lmr.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmr.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Tod0 lo que situemos aquí se mostrará en la pantalla, deberán ser Composable
        setContent {
            JetpackComposeTutorialTheme() {
                MyComponents()
            }
        }

    }
}

@Composable
fun MyComponents() {
    // Modifier.padding pone un margen en todos los lados, y arriba ya abajo del Composable
    // Si queremos poner un margen en un solo lado, podemos usar Modifier.padding(top = 8.dp) por ejemplo
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(8.dp)) {
        MyImage()
        MyTexts()
    }
}

/**
 * Composable para agregar una imagen.
 */
@Composable
fun MyImage() {
    Image(painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        // El orden de los Modifier es importante, ya que se aplican de izquierda a derecha, en el
        // siguiente caso, si pongo el clip, despues del background, la imagen será cuadrada.
        modifier = Modifier
            .clip(CircleShape) // Con Modifier.clip podemos darle forma a un Composable, en este caso, un círculo
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)// Con Modifier.background podemos poner un color de fondo a un Composable
    )
}

/**
 * Contiene dos Composable de tipo Text, haciendo uso de un Column para situarlos uno encima de otro.
 */
@Composable
fun MyTexts() {
    // Con Column podemos situar los Composable de forma vertical, en este caso, si no lo uso, se mostrarían uno encima de otro.
    Column(modifier = Modifier.padding(start = 8.dp)) { // Start es el lado izquierdo, por lo que hace padding con la imgaen (por ahora)
        MyText(
            "Hola Jetpack Compose!",
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp)) // Spacer es un Composable que nos permite añadir un espacio entre dos Composable
        MyText(
            "Preparado",
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall
        )
    }
}

/**
 * Para crear un Composable, debemos crear una función con la anotación @Composable.
 * Este Composable lo podemos utilizar en cualquier parte de nuestra aplicación.
 * En este caso, lo utilizamos en el setContent de la Activity.
 * Es un Composable muy sencillo, que recibe un String y lo muestra en pantalla en un control tipo Text.
 */
@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

/**
 * Con Preview podemos ver como se verá nuestro Composable en el diseño. Deberia ser igual que el que se muestra en la Activity.
 * Con uiMode = Configuration.UI_MODE_NIGHT_YES, indicamos que se muestre en modo oscuro en el preview.
 */
@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    JetpackComposeTutorialTheme() {
        MyComponents()
    }
}


