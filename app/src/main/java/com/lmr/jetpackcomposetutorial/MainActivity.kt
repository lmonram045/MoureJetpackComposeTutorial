package com.lmr.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmr.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

// Constante con una lista de mensajes a representar en el LazyColumn (como recyclerview)
private val messages: List<MyMessage> = listOf(
    MyMessage("Titulo 1", "Cuerpo 1"),
    MyMessage("Titulo 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 6", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 7", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 9", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 10", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 11", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 12", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 13", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 14", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 15", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 16", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 17", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage("Titulo 18", "Cuerpo 18"),
    MyMessage("Titulo 19", "Cuerpo 19"),
    MyMessage("Titulo 20", "Cuerpo 20"),
    MyMessage("Titulo 21", "Cuerpo 21"),
    MyMessage("Titulo 22", "Cuerpo 22"),
    MyMessage("Titulo 23", "Cuerpo 23"),
    MyMessage("Titulo 24", "Cuerpo 24"),
    MyMessage("Titulo 25", "Cuerpo 25"),
    MyMessage("Titulo 26", "Cuerpo 26"),
    MyMessage("Titulo 27", "Cuerpo 27"),
    MyMessage("Titulo 28", "Cuerpo 28"),
    MyMessage("Titulo 29", "Cuerpo 29"),
    MyMessage("Titulo 30", "Cuerpo 30"),
    MyMessage("Titulo 31", "Cuerpo 31"),
    MyMessage("Titulo 32", "Cuerpo 32"),
    MyMessage("Titulo 33", "Cuerpo 33")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Tod0 lo que situemos aquí se mostrará en la pantalla, deberán ser Composable
        setContent {
            JetpackComposeTutorialTheme {
                MessageList(messages)
            }
        }

    }
}

/**
 * data class para almacenar los datos de un mensaje.
 */
data class MyMessage(val title: String, val body: String)

/**
 * MessageList será el Composable que almacenará el "recyclerview" donde se mostrarán los mensajes.
 * LazyColumn es un Composable que nos permite crear listas de elementos tipo RecyclerView.
 * items() es un método de LazyColumn que nos permite crear un item por cada elemento de la lista.
 * MessageCard es un Composable que hemos creado para mostrar los datos de un mensaje. (la tarjeta o elemento en si)
 */
@Composable
fun MessageList(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

/**
 * MessageCard será el Composable que mostrará los datos de un mensaje (la tarjeta o elemento en si)
 * Row es un Composable que nos permite crear un layout horizontal para situar los elementos.
 * En la definición del Row le añadimos un modifier para darle un color de fondo y un padding.
 * Después de configurar el los atributos que queramos del Row con el modifier, añadimos los elementos.
 * MyImage es un Composable que hemos creado para mostrar una imagen.
 * MyTexts es un Composable que hemos creado para mostrar los textos del mensaje.
 */
@Composable
fun MessageCard(message: MyMessage) {
    Row(
        modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)
    ) {
        MyImage()
        MyTexts(message)
    }
}

/**
 * Imagen de la tarjeta.
 * Image es un Composable que nos permite mostrar una imagen.
 * painterResource() es un método que nos permite obtener un recurso de tipo Painter, en este caso, una imagen.
 * contentDescription es un atributo que nos permite añadir una descripción de la imagen para que sea accesible.
 * modifier es un atributo que nos permite añadir modificadores al Composable, el orden es MUY IMPORTANTE.
 * Si pusiera clip después de background, no se mostraría en forma de círculo.
 * Con Modifier.clip podemos darle forma a un Composable, en este caso, un círculo.
 * Con Modifier.background podemos poner un color de fondo a un Composable.
 * Con Modifier.size podemos definir el tamaño de un Composable.
 */
@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}

/**
 * Textos de la tarjeta.
 * Text es un Composable que nos permite mostrar 2 textos.
 * Recibe como parámetros una variable de tipo MyMessage (que hemos creado antes con los datos necesarios).
 * La variable expanded es la que controla si el texto está expandido o no, es NECESARIO usar
 * remember para que no se pierda el valor al redibujar el Composable, con mutableStateOf() le damos un valor inicial.
 * Con Column podemos situar los Composable de forma vertical.
 * Con Modifier.padding podemos añadir padding a un Composable, con start indicamos que solo sea hacia la izquierda.
 * Con Modifier.clickable podemos hacer que un Composable sea clickeable e implementamos ahí el onclick.
 * La columna contiene 2 textos separados por un Spacer que deja un espacio entre ellos.
 */
@Composable
fun MyTexts(message: MyMessage) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(start = 8.dp)
            .clickable {
                expanded = !expanded
            }
    )
    {
        MyText(
            message.title,
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

/**
 * Composable para mostrar un único texto, recibe como parámetros el texto, el color, el estilo y el número de líneas (opcional).
 */
@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

/**
 * Con Preview podemos ver como se verá nuestro Composable en el diseño. Deberia ser igual que el que se muestra en la Activity.
 * Con uiMode = Configuration.UI_MODE_NIGHT_YES, indicamos que se muestre en modo oscuro en el preview.
 * Con showSystemUi = true, indicamos que se muestre la barra de estado y la barra de navegación (pantalla completa).
 */
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    JetpackComposeTutorialTheme {
        JetpackComposeTutorialTheme {
            MessageList(messages)
        }
    }
}


