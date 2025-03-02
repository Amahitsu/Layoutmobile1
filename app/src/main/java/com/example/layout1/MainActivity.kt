package com.example.layout1

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layout1.ui.theme.Layout1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent{
                Screen()
            }
        }
    }
}


@Composable
fun Screen(){
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var isDone by remember { mutableStateOf(false) }
    var priority by remember { mutableStateOf("Medium") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text("UILabs", color = Color.White, fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Title", color = Color.White, fontSize = 30.sp)
        BasicTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))

        Text("Status", color = Color.White, fontSize = 20.sp)
        Row (verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = isDone, onClick = { isDone = true })
            Text("Done", color = Color.White, modifier = Modifier.padding(start = 4.dp),fontSize = 20.sp)
            Spacer(modifier = Modifier.width(15.dp))
            RadioButton(selected = !isDone, onClick = { isDone = false })
            Text("Not Done", color = Color.White, modifier = Modifier.padding(start = 4.dp),fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Priority:", color = Color.White, fontSize = 20.sp)
        Row {
            listOf("Low", "Medium", "High").forEach { level ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    RadioButton(selected = priority == level, onClick = { priority = level })
                    Text(level, color = Color.White, fontSize = 20.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        ButtonDateTime()
        ButtonFinal()
    }
}

@Composable
fun ButtonDateTime(){
    var date by remember { mutableStateOf("2014-02-13") }
    var time by remember { mutableStateOf("17:52:00") }

    Text("Time and Date", color = Color.White,fontSize = 20.sp)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = date, color = Color.White, fontSize = 20.sp)
        Text(text = time, color = Color.White, fontSize = 20.sp)
    }

    Spacer(modifier = Modifier.height(20.dp))
    Row(
        modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { /* Escolher Data */ }, modifier = Modifier.padding(4.dp)) {
            Text("Choose Date", fontSize = 20.sp)
        }
        Button(onClick = { /* Escolher Hora */ }, modifier = Modifier.padding(4.dp)) {
            Text("Choose Time", fontSize = 20.sp)
        }
    }

}

@Composable
fun ButtonFinal(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* Cancelar */ }) {
                Text("Cancel", fontSize = 20.sp)
            }
            Button(onClick = { /* Resetar */ }) {
                Text("Reset", fontSize = 20.sp)
            }
            Button(onClick = { /* Enviar */ }) {
                Text("Submit", fontSize = 20.sp)
            }
        }
    }
}
