package com.pfv.abzagencytesttask.ui.common.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pfv.abzagencytesttask.R
import com.pfv.abzagencytesttask.ui.theme.Black_87
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickImageBottomSheet(
    onDismiss: () -> Unit,
    onPickGalleryImg: () -> Unit,
    onPickCameraImg: () -> Unit
) {

    val state = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit){
        state.expand()
    }

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch {
                state.hide()
            }
            onDismiss()
        },
        windowInsets = WindowInsets.waterfall
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PickImageItem(
                image = R.drawable.ic_camera,
                text = stringResource(id = R.string.camera),
                onClick = {
                    coroutineScope.launch {
                        state.hide()
                    }
                    onPickCameraImg()
                }
            )
            Spacer(modifier = Modifier.width(30.dp))
            PickImageItem(
                image = R.drawable.ic_gallery,
                text = stringResource(id = R.string.gallery),
                onClick = {
                    coroutineScope.launch {
                        state.hide()
                    }
                    onPickGalleryImg()
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun RowScope.PickImageItem(
    image: Int,
    text: String,
    onClick: () -> Unit
){

    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ) {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Image(painter = painterResource(id = image), contentDescription = "")
        Text(
            text = text,
            color = Black_87,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}