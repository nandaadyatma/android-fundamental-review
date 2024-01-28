package com.example.stylingtext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.stylingtext.ui.theme.StylingTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.nunito_light, FontWeight.Light),
            Font(R.font.nunito_regular, FontWeight.Normal),
            Font(R.font.nunito_medium, FontWeight.Medium),
            Font(R.font.nunito_semibold, FontWeight.SemiBold),
            Font(R.font.nunito_bold, FontWeight.Bold),
        )

        setContent {
            StylingTextTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.fillMaxSize().background(color = Color.DarkGray)){
                    Text(
                        text = "Jetpack Joyride",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = fontFamily

                    )
                }
            }
        }
    }
}

