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
fun RegisterPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_reg),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(130.dp))

                Text(
                    text = "Create An Account",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary
                )

                Spacer(modifier = Modifier.height(8.dp))
                RegisterTextField("Name")
                Spacer(modifier = Modifier.padding(3.dp))
                RegisterTextField("Phone", keyboardType = KeyboardType.Phone)
                Spacer(modifier = Modifier.padding(3.dp))
                RegisterTextField("Email Address", keyboardType = KeyboardType.Email)
                Spacer(modifier = Modifier.padding(3.dp))
                RegisterTextField("Enter Password", keyboardType = KeyboardType.Password)
                Spacer(modifier = Modifier.padding(3.dp))
                RegisterTextField("Confirm Password", keyboardType = KeyboardType.Password)

                Spacer(modifier = Modifier.height(10.dp))
                GradientButton("Create An Account") {
                    // Handle create account action
                }

                Spacer(modifier = Modifier.height(10.dp))
                TextButton(
                    onClick = {
                        navController.navigate("login_page") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                ) {
                    Text(
                        text = "Sign In",
                        style = MaterialTheme.typography.body1,
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                TextButton(
                    onClick = {
                        navController.navigate("reset_page") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                ) {
                    Text(
                        text = "Reset Password",
                        style = MaterialTheme.typography.body1,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
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
private fun RegisterTextField(label: String, keyboardType: KeyboardType = KeyboardType.Text) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
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
@Preview
fun PreviewRegisterPage() {
    RegisterPage(navController = NavController(LocalContext.current))
}
