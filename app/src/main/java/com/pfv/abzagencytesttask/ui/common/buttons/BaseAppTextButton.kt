package com.pfv.abzagencytesttask.ui.common.buttons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pfv.abzagencytesttask.ui.theme.Black_48
import com.pfv.abzagencytesttask.ui.theme.Black_87
import com.pfv.abzagencytesttask.ui.theme.Grey

@Composable
fun BaseAppTextButton(
    modifier: Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit
) {

    TextButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = Black_48,

        )
    ) {

        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = text
        )
    }
}