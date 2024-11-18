package com.example.newsheadlines

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.newsheadlines.ui.theme.NewsHeadlinesTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(this) // Pass only the context
        }
    }
}
//
//@Composable
//fun LoginScreen(context: Context) {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var error by remember { mutableStateOf("") }
//
//    Column(
//        Modifier
//            .fillMaxHeight()
//            .fillMaxWidth()
//            .padding(28.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.news),
//            contentDescription = ""
//        )
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Row {
//            Divider(
//                color = Color.LightGray, thickness = 2.dp, modifier = Modifier
//                    .width(155.dp)
//                    .padding(top = 20.dp, end = 20.dp)
//            )
//            Text(
//                text = "Login",
//                color = Color(0xFF6495ED),
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp, style = MaterialTheme.typography.h1
//            )
//            Divider(
//                color = Color.LightGray, thickness = 2.dp, modifier = Modifier
//                    .width(155.dp)
//                    .padding(top = 20.dp, start = 20.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        TextField(
//            value = username,
//            onValueChange = { username = it },
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "personIcon",
//                    tint = Color(0xFF6495ED)
//                )
//            },
//            placeholder = {
//                Text(
//                    text = "username",
//                    color = Color.Black
//                )
//            },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.Transparent
//            )
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Lock,
//                    contentDescription = "lockIcon",
//                    tint = Color(0xFF6495ED)
//                )
//            },
//            placeholder = { Text(text = "password", color = Color.Black) },
//            visualTransformation = PasswordVisualTransformation(),
//            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
//        )
//
//        Spacer(modifier = Modifier.height(12.dp))
//        if (error.isNotEmpty()) {
//            Text(
//                text = error,
//                color = MaterialTheme.colors.error,
//                modifier = Modifier.padding(vertical = 16.dp)
//            )
//        }
//
//        Button(
//            onClick = {
//                // Check predefined username and password
//                if (username == "kuhan" && password == "1234") {
//                    error = "Successfully log in"
//                    context.startActivity(
//                        Intent(
//                            context,
//                            MainPage::class.java
//                        )
//                    )
//                } else if (username.isEmpty() || password.isEmpty()) {
//                    error = "Please fill all fields"
//                } else {
//                    error = "Invalid username or password"
//                }
//            },
//            shape = RoundedCornerShape(20.dp),
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF77a2ef)),
//            modifier = Modifier
//                .width(200.dp)
//                .padding(top = 16.dp)
//        ) {
//            Text(text = "Log In", fontWeight = FontWeight.Bold)
//        }
//
//        Row(modifier = Modifier.fillMaxWidth()) {
//            TextButton(onClick = {
//                context.startActivity(
//                    Intent(
//                        context,
//                        RegistrationActivity::class.java
//                    )
//                )
//            }) {
//                Text(
//                    text = "Sign up",
//                    color = Color.Black
//                )
//            }
//
//            Spacer(modifier = Modifier.width(100.dp))
//
//            TextButton(onClick = { /* Do something! */ }) {
//                Text(
//                    text = "Forgot password?",
//                    color = Color.Black
//                )
//            }
//        }
//    }
//}


//    new black screeen code

@Composable
fun LoginScreen(context: Context) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    // Change the overall background color
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Dark background
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Use the original image size
            Image(
                painter = painterResource(id = R.drawable.news),
                contentDescription = "" // Same image as before
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = Color.Gray,
                    thickness = 2.dp,
                    modifier = Modifier
                        .width(120.dp)
                        .padding(end = 10.dp)
                )
                Text(
                    text = "Login",
                    color = Color(0xFF77a2ef), // New text color
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Divider(
                    color = Color.Gray,
                    thickness = 2.dp,
                    modifier = Modifier
                        .width(120.dp)
                        .padding(start = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Username TextField
            TextField(
                value = username,
                onValueChange = { username = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "personIcon",
                        tint = Color(0xFF77a2ef) // Icon color
                    )
                },
                placeholder = {
                    Text(
                        text = "Username",
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF1E1E1E), // Text field background
                    textColor = Color.White, // Input text color
                    placeholderColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Password TextField
            TextField(
                value = password,
                onValueChange = { password = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "lockIcon",
                        tint = Color(0xFF77a2ef)
                    )
                },
                placeholder = {
                    Text(
                        text = "Password",
                        color = Color.Gray
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF1E1E1E),
                    textColor = Color.White,
                    placeholderColor = Color.Gray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Error Text
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // Login Button
            Button(
                onClick = {
                    if (username == "kuhan" && password == "1234") {
                        error = "Successfully logged in"
                        context.startActivity(
                            Intent(context, MainPage::class.java)
                        )
                    } else if (username.isEmpty() || password.isEmpty()) {
                        error = "Please fill all fields"
                    } else {
                        error = "Invalid username or password"
                    }
                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF77a2ef), // Button background
                    contentColor = Color.White // Button text color
                ),
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 16.dp)
            ) {
                Text(text = "Log In", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Sign Up and Forgot Password
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                TextButton(onClick = {
                    context.startActivity(
                        Intent(context, RegistrationActivity::class.java)
                    )
                }) {
                    Text(
                        text = "Sign up",
                        color = Color(0xFF77a2ef)
                    )
                }

                TextButton(onClick = { /* Do something! */ }) {
                    Text(
                        text = "Forgot password?",
                        color = Color(0xFF77a2ef)
                    )
                }
            }
        }
    }
}