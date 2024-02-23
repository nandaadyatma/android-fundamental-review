package com.example.navigationlearning2

sealed class Screen(val route: String){
   object Main: Screen("main")
    object Detail: Screen("detail")

    fun withArgs(vararg inputs: String): String{
        return buildString {
            append(route)
            inputs.forEach { input ->
                append("/$input")
            }
        }
    }
}