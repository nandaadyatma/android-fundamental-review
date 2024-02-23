package com.example.navigationlearning2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationlearning2.Screen

@Composable
fun Navigation(name: String, onNameChange: (String) -> Unit) {

    val navController = rememberNavController()
    val navHost = NavHost(navController = navController, startDestination = Screen.Main.route ){
        composable(route = Screen.Main.route){
            Main(name, onNameChange, navController)
        }
        composable(route = Screen.Detail.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "Hello"
                }
            )
        ){  backStackEntry ->
            val string = backStackEntry.arguments?.getString("name")
            Detail(string)
        }
    }

}

@Composable
fun Detail(name: String? = "") {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Hello $name")
    }
}

@Composable
fun Main(name: String, onNameChange: (String) -> Unit, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column {
            Text(text = "Insert your name")
            OutlinedTextField(value = name , onValueChange = { onNameChange(it)} )
            Button(onClick = { navController.navigate(Screen.Detail.withArgs(name)) }) {
                Text(text = "Go to Detail Screen")
                
            }
        }
    }
}
