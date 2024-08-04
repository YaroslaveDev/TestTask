package com.pfv.abzagencytesttask.ui.common.other

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.ext.isNotNull
import com.pfv.abzagencytesttask.ext.isNull
import com.pfv.abzagencytesttask.ui.common.buttons.BaseAppButton
import com.pfv.abzagencytesttask.ui.common.buttons.BaseAppTextButton
import com.pfv.abzagencytesttask.ui.theme.Black_48
import com.pfv.abzagencytesttask.ui.theme.Black_87
import com.pfv.abzagencytesttask.ui.theme.Grey

@Composable
fun SelectImageField(
    modifier: Modifier,
    error: Int?,
    value: String,
) {


    OutlinedTextField(
        enabled = false,
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {},
        isError = error.isNotNull(),
        label = {
            Text(text = stringResource(id = R.string.upload_your_photo))
        },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Black_48,
            focusedTextColor = Black_87,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Grey,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            errorContainerColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.secondary,
            errorCursorColor = MaterialTheme.colorScheme.error,
            disabledContainerColor = Color.Transparent,
            disabledIndicatorColor = if (error.isNull()) Grey else MaterialTheme.colorScheme.error,
            disabledTextColor = if (error.isNull()) Black_48 else MaterialTheme.colorScheme.error,
            disabledLabelColor = if (error.isNull()) Black_48 else MaterialTheme.colorScheme.error,
            disabledSupportingTextColor = if (error.isNull()) Black_48 else MaterialTheme.colorScheme.error
        ),
        supportingText = {
            if (error.isNotNull()) {
                Text(text = stringResource(id = R.string.photo_is_required))
            }
        },
    )
}