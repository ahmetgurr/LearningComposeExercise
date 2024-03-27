package com.ahmetgur.signuplogincompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ahmetgur.signuplogincompose.R


@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_sign_in),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Sign In",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        SimpleOutlinedTextField("Name or Email Address")

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        SimpleOutlinedPasswordTextField()

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        GradientButton("Login") {
            // Handle login action
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Button(
            onClick = { /* Handle Google sign in action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.size(26.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Continue with Google",
                    color = Color.LightGray,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        NavigationButton("Create An Account") {
            navController.navigate("register_page") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        NavigationButton("Reset Password") {
            navController.navigate("reset_page") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 20.dp))
    }
}





@Composable
private fun GradientButton(nameButton: String, onClick: () -> Unit) {
    val gradientColor = listOf(Color(0xFF484BF1), Color(0xFF673AB7))
    val cornerRadius = 16.dp
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColor),
                    shape = RoundedCornerShape(cornerRadius)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
private fun SimpleOutlinedTextField(label: String) {
    var text by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.primary
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // Do something on keyboard done
            }
        )
    )
}

@Composable
private fun SimpleOutlinedPasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter Password") },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.primary
        ),
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // Do something on keyboard done
            }
        )
    )
}

@Composable
private fun NavigationButton(text: String, onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            letterSpacing = 1.sp,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview
fun PreviewLoginPage() {
    LoginScreen(navController = NavController(LocalContext.current))
}


