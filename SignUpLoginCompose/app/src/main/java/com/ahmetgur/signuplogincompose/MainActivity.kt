package com.ahmetgur.signuplogincompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmetgur.signuplogincompose.screen.LoginScreen
import com.ahmetgur.signuplogincompose.screen.RegisterPage
import com.ahmetgur.signuplogincompose.screen.ResetPage
import com.ahmetgur.signuplogincompose.ui.theme.SignUpLoginComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpLoginComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginApplication()
                }
            }
        }
    }
}


@Composable
fun LoginApplication(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginScreen(navController = navController) })
        composable("register_page", content = { RegisterPage(navController = navController) })
        composable("reset_page", content = { ResetPage(navController = navController) })
    })
}
