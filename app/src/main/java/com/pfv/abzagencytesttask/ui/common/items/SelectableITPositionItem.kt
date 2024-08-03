package com.pfv.abzagencytesttask.ui.common.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pfv.abzagencytesttask.ui.theme.Black_87
import com.pfv.abzagencytesttask.ui.theme.Grey

@Composable
fun SelectableITPositionItem(
    modifier: Modifier,
    isSelected: Boolean,
    text: String,
    onSelect: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                onSelect()
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        RadioButton(
            selected = isSelected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.secondary,
                unselectedColor = Grey
            )
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = text,
            color = Black_87,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}