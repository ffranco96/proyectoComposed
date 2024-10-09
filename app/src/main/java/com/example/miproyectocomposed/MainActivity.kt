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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miproyectocomposed.ui.theme.MiProyectoComposedTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiProyectoComposedTheme(){
                MyMenu(listOf("Sincronizar", "Contar"))
            }
        }
    }
}

@Composable
fun MyMenu(options : List<String>){
    ProvideTextStyle(value = MaterialTheme.typography.bodySmall) {
        val scrollState = rememberScrollState()
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .verticalScroll(scrollState)) {
            MyImage()
            options.forEach(){
                Spacer(modifier = Modifier.height(8.dp))
                MyButton(it)
            }
        }
    }
}

@Composable
fun MyButton(buttonText: String, modifier: Modifier = Modifier.padding(horizontal = 20.dp)) {
    Button(onClick = { /*TODO*/ }) {
        Text(
            text = "$buttonText",
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun MyImage(){
    Image(painterResource(R.drawable.ic_launcher_foreground),
    "Mi imagen",
    modifier = Modifier
        .size(30.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.onBackground))
}

@Preview(showSystemUi = true)
@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MenuPreview() {
    MyMenu(listOf("Sincronizar", "Contar", "Contar", "Contar", "Contar", "Contar", "Contar",
        "Contar", "Contar", "Contar", "Contar", "Contar2", "Contar3", "Contar4", "Contar5",
        "Contar6", "Contar7","Contar8", "Contar9"))
}