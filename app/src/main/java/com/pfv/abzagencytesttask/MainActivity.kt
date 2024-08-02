package com.pfv.abzagencytesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pfv.abzagencytesttask.ui.navigation.RootNavGraph
import com.pfv.abzagencytesttask.ui.theme.AbzagencyTestTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbzagencyTestTaskTheme {

                enableEdgeToEdge()

                RootNavGraph(navHostController = rememberNavController())

            }
        }
    }
}
