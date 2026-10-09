package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.core.net.toUri

const val KEY_TEXT = "KEY_TEXT"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    FirstScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class FirstViewModel : ViewModel() {
    var text by mutableStateOf("")
    var isError by mutableStateOf(false)
}

@Composable
fun FirstScreen(viewModel: FirstViewModel = viewModel(), modifier: Modifier){
    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = viewModel.text,
            onValueChange = { viewModel.text = it },
            label = { Text("Введите текст") },
            isError = viewModel.isError,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        if(viewModel.isError){Text("Неподходящий формат данных", modifier = Modifier.padding(bottom = 16.dp))}
        Button(
            onClick = { if (viewModel.text.isBlank()){
                    viewModel.isError = true
                } else{
                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra(KEY_TEXT, viewModel.text)
                    context.startActivity(intent)
                }
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ){
            Text("Передать строку")
        }
        Button(
            onClick = {
                if (Patterns.PHONE.matcher(viewModel.text).matches()){
                    viewModel.isError = false
                    val intent = Intent(Intent.ACTION_DIAL, "tel:${viewModel.text}".toUri())
                    context.startActivity(intent)
                } else{
                    viewModel.isError = true
                }
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ){
            Text("Позвонить другу")
        }
        Button(
            onClick = {if (viewModel.text.isBlank()){
                viewModel.isError = true
            } else{
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, viewModel.text)
                }
                context.startActivity(Intent.createChooser(intent, "Поделиться через…"))
            } },
            modifier = Modifier.padding(bottom = 16.dp)
        ){
            Text("Поделиться текстом")
        }
    }
}