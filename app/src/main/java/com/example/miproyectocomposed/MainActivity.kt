package com.example.miproyectocomposed

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miproyectocomposed.ui.theme.MiProyectoComposedTheme

private val registersListInstance = listOf("Registro1",
    "Registro2",
    "Registro3",
    "Registro4",
    "Registro5",
    "Registro6",
    "Registro7",
    "Registro8",
    "Registro9",
    "Registro10",
    "Registro11",
    "Registro12",
    "Registro13",
    "Registro14",
    "Registro15",
    "Registro16",
    "Registro17",
    "Registro18",
    "Registro19")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiProyectoComposedTheme(){
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
fun RegistersList(registerDetailList : List<String>){
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
fun Register(regText: String) {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.background)
        .padding(8.dp)) {
        MyImage()
        RegisterContent(regText)
    }
}

@Composable
fun RegisterContent(regText: String) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        RegisterTitle(regText) /*TODO pasar title por parametro*/
        RegisterDescription(regText) /*TODO pasar desc por parametro*/
    }
}

@Composable
fun RegisterTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelLarge
    )
}

@Composable
fun RegisterDescription(desc: String) {
    Text(
        text = desc,
        style = MaterialTheme.typography.labelMedium
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
fun RegistersListPreview() {
    RegistersList(registersListInstance)
}