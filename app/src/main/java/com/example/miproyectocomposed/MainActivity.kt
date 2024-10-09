package com.example.miproyectocomposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            MyMenu()
        }
    }
}

@Composable
fun MyMenu(){
    ProvideTextStyle(value = MaterialTheme.typography.bodySmall) {
        Column {
            MyButton("Sincronizar")
            Spacer(modifier = Modifier.height(16.dp))
            MyButton("Contar")
            MyImage()
        }
    }
}

@Composable
fun MyButton(buttonText: String, modifier: Modifier = Modifier.padding(horizontal = 20.dp)) {
    Button(onClick = { /*TODO*/ }) {
        Text(
            text = "$buttonText",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Green
        )
    }
}

@Composable
fun MyImage(){
    Image(painterResource(R.drawable.ic_launcher_foreground),
    "Mi imagen")
}

@Preview
@Composable
fun MenuPreview() {
    MyMenu()
}