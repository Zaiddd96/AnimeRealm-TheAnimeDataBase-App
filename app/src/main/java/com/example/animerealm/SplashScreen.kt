package com.example.animerealm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
){
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("HomeScreen") {
            popUpTo("SplashScreen")
            { inclusive = true }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF001F3F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.animerealm),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(59.dp)
        )
    }
}
