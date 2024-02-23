package com.example.navigationlearning1

sealed class Screen(val route: String) {
    object Main: Screen("main")
    object Second: Screen("second")

    fun withArguments(vararg inputs: String): String{
        return buildString {
            append(route)
            inputs.forEach { input ->
                append("/$input")
            }
        }
    }
}