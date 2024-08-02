package com.pfv.abzagencytesttask.ui.screens.sign_up

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AddNewUserScreen(
    navController: NavController
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Text(text = "AddNewUserScreen")
        }
    }
}