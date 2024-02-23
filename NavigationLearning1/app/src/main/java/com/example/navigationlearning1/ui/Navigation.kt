package com.example.navigationlearning1.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationlearning1.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val navHost = NavHost(navController = navController, startDestination = Screen.Main.route){
        composable(route = Screen.Main.route
        ){
            Home(navController = navController)
        }
        composable(route = Screen.Second.route){
            Second()
        }
    }
}

@Composable
fun Home(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column {

            OutlinedTextField(value = text, onValueChange = {changes -> text = changes}, label = { Text(
                text = "Your name"
            )})
            Button(onClick = { navController.navigate(Screen.Second.route)}, modifier = Modifier.align(alignment = Alignment.End)) {
                Text(text = "to second screen")
            }
        }
    }
}

@Composable
fun Second() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Hello")

    }
}
