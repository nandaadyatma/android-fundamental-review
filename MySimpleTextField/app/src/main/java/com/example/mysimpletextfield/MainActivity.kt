package com.example.mysimpletextfield

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mysimpletextfield.ui.MainViewModel
import com.example.mysimpletextfield.ui.theme.MySimpleTextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel by viewModels<MainViewModel>()
            MySimpleTextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        TextField(modifier = Modifier.fillMaxWidth(), text = viewModel.text.value, onChanges = {viewModel.onTextChange(it)})

                        Checkbox(checked = viewModel.checked.value, onCheckedChange = {viewModel.onCheckChange(it)})

                        Button(onClick = { viewModel.addTask(viewModel.text.value) }) {
                            Text(text = "Add task")

                        }

                        LazyColumn(modifier = Modifier.fillMaxWidth()){
                            val task = viewModel.listTask.toList()
                            items(task){ task ->
                                Text(text = task)
                                Divider()
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    text: String,
    onChanges: (String) -> Unit
) {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(value = text, onValueChange = { onChanges(it)}, label = { Text(
        text = "Text", modifier = modifier
    )} )



}

