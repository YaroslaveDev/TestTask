package com.pfv.abzagencytesttask.ui.common.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pfv.abzagencytesttask.ui.theme.Black_48
import com.pfv.abzagencytesttask.ui.theme.Black_87
import com.pfv.abzagencytesttask.ui.theme.Grey

@Composable
fun BaseAppButton(
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Grey,
            contentColor = Black_87,
            disabledContentColor = Black_48
        ),
        enabled = enabled
    ) {

        Text(
            text = text
        )
    }
}

@Preview()
@Composable
fun BaseAppButton_Preview(){

    BaseAppButton(
        text = "Button",
        enabled = false
    ) {

    }
}

