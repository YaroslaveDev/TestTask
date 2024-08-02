package com.pfv.abzagencytesttask.ui.common.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pfv.abzagencytesttask.ui.theme.Black_48
import com.pfv.abzagencytesttask.ui.theme.Black_87

@Composable
fun BaseAppInputField(
    modifier: Modifier,
    label: String,
    supportingText: String,
    isError: Boolean,
    value: String,
    onValueChanged: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        isError = isError,
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Black_48,
            focusedTextColor = Black_87,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error
        ),
        supportingText = {
            Text(text = supportingText)
        }
    )
}

@Preview
@Composable
fun BaseAppInputField_Preview(){

//    BaseAppInputField(
//        modifier = Modifier
//            .fillMaxWidth(),
//        isError = false,
//        value = "",
//        onValueChanged = {},
//        label = ""
//    )
}