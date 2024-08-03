package com.pfv.abzagencytesttask.ui.common.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.ui.common.buttons.BaseAppButton
import com.pfv.abzagencytesttask.ui.theme.Black_87

@Composable
fun InfoScreen(
    actionText: String,
    text: String,
    img: Int,
    onAction: () -> Unit,
    onCloseInfoScreen: () -> Unit
) {

    Dialog(
        properties = DialogProperties(),
        onDismissRequest = { }
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp)

        ){

//            IconButton(
//                modifier = Modifier
//                    //.statusBarsPadding()
//                    .align(alignment = Alignment.TopEnd),
//                onClick = onCloseInfoScreen
//            ) {
//                Icon(painter = painterResource(id = R.drawable.ic_close), contentDescription = "img")
//            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = img),
                    contentDescription = "img"
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = text,
                    color = Black_87,
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(24.dp))

                BaseAppButton(
                    modifier = Modifier,
                    text = actionText,
                    onClick = onAction
                )

            }

        }
    }
}