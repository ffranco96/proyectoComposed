package com.example.miproyectocomposed

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miproyectocomposed.model.database.RegisterEntity
import com.example.miproyectocomposed.navigation.AppNavigation
import com.example.miproyectocomposed.screens.HomeStartScreen
import com.example.miproyectocomposed.ui.theme.MiProyectoComposedTheme

private val registersListInstance = listOf(
    RegisterEntity(-1000.00,"Club de la milanesa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-2000.00,"Club de la milanesa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-3000.00,"Club de la milanesa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-4000.00,"Club de la milanesa", "", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-5000.00,"Club de la milanesa", "Lorem ipsum", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-6000.00,"Club de la milanesa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-7000.00,"Club de la milanesa", "Pagamos a medias con mis amigos", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-8000.00,"Club de la milanesa", "Pagamos a medias con mis amigos", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-9000.00,"Club de la milanesa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-10000.00,"Club de la milanesa", "Pagamos a medias con mis amigos", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-11000.00,"Club de la milanesa", "Pagamos a medias con mis amigos", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-12000.00,"Club de la milanesa", "Pagamos a medias con mis amigos", "Restaurant y comida rapida", "2024-05-25", "ARS") ,
    RegisterEntity(-13000.00,"Club de la milanesa", "Pagamos a medias con mis amigos", "Restaurant y comida rapida", "2024-05-25", "ARS") )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiProyectoComposedTheme(){
//                AppNavigation() // Sabe cual es la primera pantalla
                RegistersList(registersListInstance)
            }
        }
    }
}

/*@Composable
fun MyMenu(options : List<String>){
    Column( // Usamos Column para colocar la imagen arriba y las opciones abajo
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centrar la imagen y las opciones horizontalmente
    ) {
    //ProvideTextStyle(value = MaterialTheme.typography.bodySmall) {
        MyImage()
        Spacer(modifier = Modifier.height(16.dp))
        MyOptions(options)
    }
}*/

@Composable
fun RegistersList(registerDetailList : List<RegisterEntity>){
    LazyColumn(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        items(registerDetailList){registerDetail ->
            Spacer(modifier = Modifier.height(8.dp))
            Register(registerDetail)
        }
    }
}

/*@Composable
fun MyButton(buttonText: String, modifier: Modifier = Modifier.padding(horizontal = 20.dp)) {
    Button(onClick = { /*TODO*/ }, Modifier.fillMaxWidth(0.8f)) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.labelLarge
        )
    }
}*/

@Composable
fun Register(regEntityData: RegisterEntity) {
    val regTextData = listOf(regEntityData.title, regEntityData.description) // TODO Temporal
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background)
        .padding(8.dp)) {
        MyImage()
        RegisterContent(regTextData)
    }
}

@Composable
fun RegisterContent(regTextData: List<String>) {
    var expanded by remember {mutableStateOf(false)} // Necesitamos que la variable mute en tiempo de ejecucion.
                        // Ademas necesitamos que la variable mute a nivel de estado, y que
                        // esto produzca que se repinte la interfaz
    Column(modifier = Modifier.padding(start = 8.dp).clickable {
        expanded = !expanded
    }) {
        RegisterTitle(regTextData[0], MaterialTheme.typography.labelLarge) /*TODO pasar title por parametro*/
        RegisterDescription(
            regTextData[1],
            MaterialTheme.typography.labelMedium,

            if(expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun RegisterTitle(title: String, style: TextStyle) {
    Text(
        text = title,
        style = style
    )
}

@Composable
fun RegisterDescription(desc: String, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(
        text = desc,
        style = style,
        maxLines = lines
    )
}

@Composable
fun MyImage(){
    Image(painterResource(R.drawable.ic_launcher_foreground),
    "Mi imagen",
    modifier = Modifier
        .size(50.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.onBackground))
}

@Preview(showSystemUi = true)
@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview(){
    AppNavigation()
}