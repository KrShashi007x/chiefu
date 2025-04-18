package com.krshashi.chiefu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.krshashi.chiefu.ui.theme.ChiefuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkAppTheme by remember { mutableStateOf(false) }
            var isDarkSystemTheme by remember { mutableStateOf(false) }

            SetSystemBarColor(isDarkSystemTheme)
            ChiefuTheme(darkTheme = isDarkAppTheme) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Column(Modifier.align(Alignment.Center)) {
                            Greeting(
                                name = "Android",
                                modifier = Modifier.padding(innerPadding)
                            )
                            Button(onClick = {
                                isDarkAppTheme = !isDarkAppTheme
                                isDarkSystemTheme = !isDarkSystemTheme
                            }) {
                                Text(text = "Change Theme")
                            }
                        }
                    }

                }
            }
        }
    }

    @Composable
    private fun SetSystemBarColor(isDarkTheme: Boolean) {
        LaunchedEffect(isDarkTheme) {
            when (isDarkTheme) {
                true -> enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(0),
                    navigationBarStyle = SystemBarStyle.dark(0)
                )

                false -> enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(0, 0),
                    navigationBarStyle = SystemBarStyle.light(0, 0)
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChiefuTheme {
        Greeting("Android")
    }
}